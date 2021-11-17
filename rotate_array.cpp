/* 
 * PS: Rotate an array by d elements clockwise
 * We were trying to solve in O(n), Auxilary space O(1)
 */

#include <iostream>
#include <numeric>
using namespace std;

void leftRotate(int* arr, int d, int n) {
    int g_c_d = gcd(n, d);
    for (int i=0; i<g_c_d; i++) {
        int j = i;
        int temp = arr[j];

        while (true) {
            int k = j + d;
            if (k >= n) {
                k -= n; // or k = k % n
            }

            if (k == i) {
                break;
            }
            arr[j] = arr[k];
            j = k;
        }
        arr[j] = temp;
    }
}

int main() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int n = sizeof(arr)/sizeof(arr[0]);

    leftRotate(arr, 4, n);
    for (int i=0; i<n; i++) {
        cout << arr[i] << " "; 
    }
    cout << endl;

    return 0;
}