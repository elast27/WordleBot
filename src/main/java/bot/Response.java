package bot;

import java.util.List;

public class Response {
	
	Request request;
	String letters_for_search;
	long search_results;
	int search_duration;
	int filter_results;
	int filter_duration;
	List<WordPages> word_pages;
	int returned_results;
	int pagination_duration;
	DictMatches dict_matches;
	boolean has_dict_match;
	
	private class DictMatches{
		boolean otcwl;
		boolean sowpods;
		boolean wordle;
		boolean wwf;
		public boolean isOtcwl() {
			return otcwl;
		}
		public void setOtcwl(boolean otcwl) {
			this.otcwl = otcwl;
		}
		public boolean isSowpods() {
			return sowpods;
		}
		public void setSowpods(boolean sowpods) {
			this.sowpods = sowpods;
		}
		public boolean isWordle() {
			return wordle;
		}
		public void setWordle(boolean wordle) {
			this.wordle = wordle;
		}
		public boolean isWwf() {
			return wwf;
		}
		public void setWwf(boolean wwf) {
			this.wwf = wwf;
		}
		public DictMatches() {
			super();
		}
		
	}
	private class Request{
		String letters;
		String starts_with;
		String ends_with;
		int shorter_than;
		int longer_than;
		int length;
		String must_contain;
		String must_not_contain;
		String must_contain_multiple;
		String must_contain_char1;
		String must_contain_char2;
		String contains;
		String not_contains;
		String include_letters;
		String exclude_letters;
		String contains_multiple;
		String contains_char1;
		String contains_char2;
		String pattern;
		String regexp;
		String dictionary;
		boolean return_results;
		boolean pre_defined;
		boolean is_search;
		boolean group_by_length;
		int page_size;
		int page_token;
		boolean sort_alphabet;
		String word_sorting;
		int letter_limit;
		public String getLetters() {
			return letters;
		}
		public void setLetters(String letters) {
			this.letters = letters;
		}
		public String getStarts_with() {
			return starts_with;
		}
		public void setStarts_with(String starts_with) {
			this.starts_with = starts_with;
		}
		public String getEnds_with() {
			return ends_with;
		}
		public void setEnds_with(String ends_with) {
			this.ends_with = ends_with;
		}
		public int getShorter_than() {
			return shorter_than;
		}
		public void setShorter_than(int shorter_than) {
			this.shorter_than = shorter_than;
		}
		public int getLonger_than() {
			return longer_than;
		}
		public void setLonger_than(int longer_than) {
			this.longer_than = longer_than;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public String getMust_contain() {
			return must_contain;
		}
		public void setMust_contain(String must_contain) {
			this.must_contain = must_contain;
		}
		public String getMust_not_contain() {
			return must_not_contain;
		}
		public void setMust_not_contain(String must_not_contain) {
			this.must_not_contain = must_not_contain;
		}
		public String getMust_contain_multiple() {
			return must_contain_multiple;
		}
		public void setMust_contain_multiple(String must_contain_multiple) {
			this.must_contain_multiple = must_contain_multiple;
		}
		public String getMust_contain_char1() {
			return must_contain_char1;
		}
		public void setMust_contain_char1(String must_contain_char1) {
			this.must_contain_char1 = must_contain_char1;
		}
		public String getMust_contain_char2() {
			return must_contain_char2;
		}
		public void setMust_contain_char2(String must_contain_char2) {
			this.must_contain_char2 = must_contain_char2;
		}
		public String getContains() {
			return contains;
		}
		public void setContains(String contains) {
			this.contains = contains;
		}
		public String getNot_contains() {
			return not_contains;
		}
		public void setNot_contains(String not_contains) {
			this.not_contains = not_contains;
		}
		public String getInclude_letters() {
			return include_letters;
		}
		public void setInclude_letters(String include_letters) {
			this.include_letters = include_letters;
		}
		public String getExclude_letters() {
			return exclude_letters;
		}
		public void setExclude_letters(String exclude_letters) {
			this.exclude_letters = exclude_letters;
		}
		public String getContains_multiple() {
			return contains_multiple;
		}
		public void setContains_multiple(String contains_multiple) {
			this.contains_multiple = contains_multiple;
		}
		public String getContains_char1() {
			return contains_char1;
		}
		public void setContains_char1(String contains_char1) {
			this.contains_char1 = contains_char1;
		}
		public String getContains_char2() {
			return contains_char2;
		}
		public void setContains_char2(String contains_char2) {
			this.contains_char2 = contains_char2;
		}
		public String getPattern() {
			return pattern;
		}
		public void setPattern(String pattern) {
			this.pattern = pattern;
		}
		public String getRegexp() {
			return regexp;
		}
		public void setRegexp(String regexp) {
			this.regexp = regexp;
		}
		public String getDictionary() {
			return dictionary;
		}
		public void setDictionary(String dictionary) {
			this.dictionary = dictionary;
		}
		public boolean isReturn_results() {
			return return_results;
		}
		public void setReturn_results(boolean return_results) {
			this.return_results = return_results;
		}
		public boolean isPre_defined() {
			return pre_defined;
		}
		public void setPre_defined(boolean pre_defined) {
			this.pre_defined = pre_defined;
		}
		public boolean isIs_search() {
			return is_search;
		}
		public void setIs_search(boolean is_search) {
			this.is_search = is_search;
		}
		public boolean isGroup_by_length() {
			return group_by_length;
		}
		public void setGroup_by_length(boolean group_by_length) {
			this.group_by_length = group_by_length;
		}
		public int getPage_size() {
			return page_size;
		}
		public void setPage_size(int page_size) {
			this.page_size = page_size;
		}
		public int getPage_token() {
			return page_token;
		}
		public void setPage_token(int page_token) {
			this.page_token = page_token;
		}
		public boolean isSort_alphabet() {
			return sort_alphabet;
		}
		public void setSort_alphabet(boolean sort_alphabet) {
			this.sort_alphabet = sort_alphabet;
		}
		public String getWord_sorting() {
			return word_sorting;
		}
		public void setWord_sorting(String word_sorting) {
			this.word_sorting = word_sorting;
		}
		public int getLetter_limit() {
			return letter_limit;
		}
		public void setLetter_limit(int letter_limit) {
			this.letter_limit = letter_limit;
		}
		public Request() {
			super();
		}
		
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public String getLetters_for_search() {
		return letters_for_search;
	}
	public void setLetters_for_search(String letters_for_search) {
		this.letters_for_search = letters_for_search;
	}
	public long getSearch_results() {
		return search_results;
	}
	public void setSearch_results(long search_results) {
		this.search_results = search_results;
	}
	public int getSearch_duration() {
		return search_duration;
	}
	public void setSearch_duration(int search_duration) {
		this.search_duration = search_duration;
	}
	public int getFilter_results() {
		return filter_results;
	}
	public void setFilter_results(int filter_results) {
		this.filter_results = filter_results;
	}
	public int getFilter_duration() {
		return filter_duration;
	}
	public void setFilter_duration(int filter_duration) {
		this.filter_duration = filter_duration;
	}
	public List<WordPages> getWord_pages() {
		return word_pages;
	}
	public void setWord_pages(List<WordPages> word_pages) {
		this.word_pages = word_pages;
	}
	public int getReturned_results() {
		return returned_results;
	}
	public void setReturned_results(int returned_results) {
		this.returned_results = returned_results;
	}
	public int getPagination_duration() {
		return pagination_duration;
	}
	public void setPagination_duration(int pagination_duration) {
		this.pagination_duration = pagination_duration;
	}
	public DictMatches getDict_matches() {
		return dict_matches;
	}
	public void setDict_matches(DictMatches dict_matches) {
		this.dict_matches = dict_matches;
	}
	public boolean isHas_dict_match() {
		return has_dict_match;
	}
	public void setHas_dict_match(boolean has_dict_match) {
		this.has_dict_match = has_dict_match;
	}
	
	public Response() {
		super();
	}
	
	
}
