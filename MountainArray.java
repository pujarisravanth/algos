public class MountainArray {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 6, 5 };
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // walk up
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        // walk down
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
