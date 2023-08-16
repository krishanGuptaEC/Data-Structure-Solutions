public class Solution {
    public static void swap(int n[], int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    public static void reverse(int n[], int i, int j) {
        while (i < j) {
            swap(n, i, j);
            i++;
            j--;
        }
    }

    public int[] nextPermutation(int[] A) {
        int n = A.length;
        int idx = -1;

        // Find the index of the first element that is smaller than its next element
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no such index is found, reverse the entire array and return
        if (idx == -1) {
            reverse(A, 0, n - 1);
            return A;
        }

        // Find the index of the smallest element greater than A[idx] to the right of idx
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] > A[idx]) {
                swap(A, i, idx);
                reverse(A, idx + 1, n - 1);
                return A;
            }
        }

        return A;
    }
}
