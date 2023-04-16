public class PairsOfSongs {
    public static void main(String[] args) {
        int[] nums = { 30, 20, 150, 100, 40 };
        int cnt = numPairsDivisibleBy60(nums);
        System.out.println(cnt);
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int cnt = 0;
        int[] arr = new int[60];

        for (int num : time) {
            num = num % 60;
            if (num == 0) {
                cnt += arr[0];
            } else {
                cnt += arr[60 - num];
            }

            arr[num]++;
        }

        return cnt;
    }
}
