import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem #1431, Kids With the Greatest Number of Candies
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class KidsWithGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = new int[] { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max)
                max = candies[i];
        }

        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= max);
        }

        return list;
    }
}
