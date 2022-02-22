package bot;

import java.util.HashMap;
import java.util.Map;

public class Request {
	String length = "5";
	String word_sorting = "points";
	String group_by_length = "true";
	String page_size = "20";
	String dictionary = "wordle";
	String page_token = "1";
	Map<String, String> parameters = new HashMap<>();
	public Request(String contains, String exclude_letters, String include_letters) {
		parameters.put("contains", contains);
		parameters.put("exclude_letters", exclude_letters);
		parameters.put("include_letters", include_letters);
		parameters.put("length", length);
		parameters.put("word_sorting", word_sorting);
		parameters.put("group_by_length", group_by_length);
		parameters.put("page_size", page_size);
		parameters.put("dictionary", dictionary);
		parameters.put("page_token", page_token);
	}
	public Map<String, String> getParams(){
		return this.parameters;
	}
}
