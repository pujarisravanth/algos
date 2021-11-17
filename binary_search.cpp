#include <iostream>
using namespace std;

int binarySearch(int arr[], int l, int r, int key) {
    if (r < l) return -1;

    int mid = (l + r)/2;
    if (arr[mid] == key) return mid;
    if (arr[mid] > key) return binarySearch(arr, l, mid-1, key);
    return binarySearch(arr, mid+1, r, key);
}

int main() {
    int arr[] = {1, 2, 4, 5, 6, 7, 9, 14, 15, 16};
    int n = sizeof(arr)/sizeof(arr[0]);

    int key = 14;
    cout << binarySearch(arr, 0, n-1, key) << endl;

    return 0;
}