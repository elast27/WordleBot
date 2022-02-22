package bot;

import java.util.List;

public class Word{
	String word;
	int points;
	List<String> wildcards;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public List<String> getWildcards() {
		return wildcards;
	}
	public void setWildcards(List<String> wildcards) {
		this.wildcards = wildcards;
	}
	public Word() {
		super();
	}
}
