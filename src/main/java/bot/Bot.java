package bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Bot {
	static HttpURLConnection conn;
	static String contains = "__i__";
	static String exclude_letters = "lahrgoy";
	static String include_letters = "tste";
	static char[][] letters_not = {{},{'e'},{'t'},{'e','s'},{'t'}};
	
	public static void main(String[] args) {
		List<Word> remaining = new ArrayList<>();
		String length = "5";
		String word_sorting = "points";
		String group_by_length = "true";
		String page_size = "20";
		String dictionary = "wordle";
		String page_token = "1";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("contains", contains);
		parameters.put("exclude_letters", exclude_letters);
		parameters.put("include_letters", include_letters);
		parameters.put("length", length);
		parameters.put("word_sorting", word_sorting);
		parameters.put("group_by_length", group_by_length);
		parameters.put("page_size", page_size);
		parameters.put("dictionary", dictionary);
		parameters.put("page_token", page_token);
		try {
			String queryParam =  ParameterStringBuilder.getParamsString(parameters);
			String endpoint = "https://fly.wordfinderapi.com/api/search?"+queryParam;
			Response resp = connect(endpoint);
			int n = resp.word_pages.get(0).num_pages;
			if(n >= 1) {
				for(int i = 0; i < n; ++i) {
					WordPages l = resp.word_pages.get(0);
					parameters.put("page_token", ((Integer.parseInt(parameters.get("page_token")))+1)+"");
					queryParam = ParameterStringBuilder.getParamsString(parameters);
					endpoint = "https://fly.wordfinderapi.com/api/search?"+queryParam;
					resp = connect(endpoint);
					for(Word w : l.word_list) {
//						System.out.println(w.word);
						remaining.add(w);
					}
				}	
				System.out.println("Your next word should be: "+pickWord(remaining).word); 
			}
			else {
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
			}
			conn.disconnect();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Response connect(String endpoint) {
		try {
			URL url = new URL(endpoint);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			int status = conn.getResponseCode();
			if(status==200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				
				ObjectMapper mapper = new ObjectMapper();
				Response resp = mapper.readValue(content.toString(), Response.class);
				return resp;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Word pickWord(List<Word> remaining) {
		remaining = filterList(remaining);
		Map<Character, Integer> letterScore = new HashMap<>();
		Map<Word, Integer> wordScore = new HashMap<>();
		
		for(Word w : remaining) {
			String s = w.word;
			for(int i = 0; i < 5; i++) {
				int score = letterScore.containsKey(s.charAt(i)) ? letterScore.get(s.charAt(i)) : 0;
				letterScore.put(s.charAt(i), score+1);
			}
		}
		for(Word w : remaining) {
			int score = 0;
			String sb = "";
			String s = w.word;
			for(int i = 0; i < 5; i++) {
				if(!sb.contains(s.substring(i,i+1))) {
					sb+=s.charAt(i);
					score+=letterScore.get(s.charAt(i));
				}
			}
			wordScore.put(w, score);
		}
		wordScore = sortByValue(wordScore);
		
		Entry<Word, Integer> maxEntry = null;
		for (Entry<Word, Integer> entry : wordScore.entrySet()){
			System.out.println(entry.getKey().word + ": " + entry.getValue());
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		        maxEntry = entry;
		}
		return maxEntry.getKey();
	}

	public static List<Word> filterList(List<Word> l){
		List<Word> res = new ArrayList<>();
		res.addAll(l);
		for(Word w : l) {
			String s = w.word;
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < letters_not[i].length; j++) {
					if(s.charAt(i)==letters_not[i][j]) {
						if(res.contains(w)) res.remove(w);
						break;
					}
				}
			}
		}
		return res;
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        
        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
