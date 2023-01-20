public class FindPivotInRotatedArray {
    
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        int pivot = findPivot(arr, 0, arr.length - 1);
        System.out.println("Pivot is at index " + pivot);
    }

    public static int findPivot(int[] arr, int low, int high) {
        if (high < low) return -1;

        int mid = low + (high - low) / 2;
        if (mid < high && arr[mid] > arr[mid + 1]) return mid + 1;
        if (mid > low && arr[mid] < arr[mid - 1]) return mid;

        if (arr[low] >= arr[mid]) return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }   
}
