#include <iostream>
using namespace std;

int findPivot(int arr[], int low, int high) {
    if (low > high)
        return -1;

    if (low == high)
        return low;

    int mid = (low + high) / 2;
    
    if (mid < high && arr[mid] > arr[mid+1])
        return mid+1;
    
    if (mid > low && arr[mid] < arr[mid-1])
        return mid;

    if (arr[low] >= arr[mid])
        return findPivot(arr, low, mid-1);
    
    return findPivot(arr, mid+1, high);
}

int main() {
    int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
    int n = sizeof(arr) / sizeof(arr[0]);
    
    int pivot = findPivot(arr, 0, n-1);
    cout << pivot << endl;

    return 0;
}