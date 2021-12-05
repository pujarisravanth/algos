public class BinarySearch {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 3;

        int index = binarySearch(arr, key, 0, arr.length - 1);
        System.out.println("Index of " + key + " is " + index);
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) return -1;
        
        int mid = (low + high) /2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] > key) return binarySearch(arr, key, low, mid-1);
        else return binarySearch(arr, key, mid+1, high);
    }
}
