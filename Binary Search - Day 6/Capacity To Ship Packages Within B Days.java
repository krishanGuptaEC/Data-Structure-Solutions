public class Solution {
    // Helper function to check if it's possible to split the array with a given maximum sum
    public boolean check(int[] A, int mid, int B) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum > mid) {
                B--;       // Decrement the number of splits remaining
                sum = A[i]; // Reset the sum for the next split
            }
        }
        return B > 0; // Return true if all splits are used up
    }
    
    // Function to find the minimum maximum sum possible after splitting the array
    public int solve(int[] A, int B) {
        int n = A.length;
        int low = A[0];
        int high = A[0];
        for (int i = 1; i < n; i++) {
            low = Math.max(low, A[i]); // Find the maximum element in the array
            high += A[i];              // Calculate the total sum of the array
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(A, mid, B)) {
                high = mid - 1; // Adjust high to search lower maximum sum
            } else {
                low = mid + 1;  // Adjust low to search higher maximum sum
            }
        }
        return high + 1; // Return the minimum maximum sum after splitting
    }
}
