package bot;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class AvgCalc {

	static List<Integer> guesses = Arrays.asList(
			2,2,3,4,4,4,3,4,4,4,3,3,3,3,4,3,4,3,
			2,4
	);
	
	public static void main(String[] args) {
		IntSummaryStatistics stats = guesses.stream().mapToInt(x->x).summaryStatistics();
		System.out.println(stats);
	}
}
