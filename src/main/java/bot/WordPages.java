package bot;

import java.util.List;

public class WordPages{
	List<Word> word_list;
	int length;
	int num_words;
	int num_pages;
	int current_page;
	public List<Word> getWord_list() {
		return word_list;
	}
	public void setWord_list(List<Word> word_list) {
		this.word_list = word_list;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getNum_words() {
		return num_words;
	}
	public void setNum_words(int num_words) {
		this.num_words = num_words;
	}
	public int getNum_pages() {
		return num_pages;
	}
	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	public WordPages() {
		super();
	}
}
