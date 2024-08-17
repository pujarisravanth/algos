import java.util.List;

/**
 * Stacking the signal filters and allowing only which can pass through all the
 * filters. Each filter allow only some range of frequencies. Find the number of
 * signals that will go through with a given frequency.
 */
public class CountSignals {
    public static void main(String[] args) {
        List<Integer> frequencies = List.of(8, 15, 14, 16, 21);
        List<List<Integer>> filterRanges = List.of(List.of(10, 17), List.of(13, 15), List.of(13, 17));

        int allowedSignals = countSignals(frequencies, filterRanges);
        System.out.println(allowedSignals);
    }

    public static int countSignals(List<Integer> frequencies, List<List<Integer>> filterRanges) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for (var range : filterRanges) {
            min = Math.max(range.get(0), min);
            max = Math.min(range.get(1), max);
        }

        int res = 0;
        for (int f : frequencies) {
            if (f >= min && f <= max) {
                res++;
            }
        }

        return res;
    }
}
