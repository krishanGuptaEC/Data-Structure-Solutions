public class Solution {
    // Binary search function to find the index where x could be inserted in sorted array A
    public int solve(int[] A, int x) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < x) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return low; // Return the index where x could be inserted
    }
    
    // Function to find the median value in a 2D matrix
    public int findMedian(int[][] A) {
        int n = A.length;       // Number of rows
        int m = A[0].length;    // Number of columns
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            // Count the number of elements less than or equal to mid in each row
            for (int i = 0; i < n; i++) {
                count += solve(A[i], mid);
            }
            if (count <= (n * m) / 2) {
                low = mid + 1; // Adjust low to search higher values
            } else {
                high = mid - 1; // Adjust high to search lower values
            }
        }
        return low - 1; // Return the median value
    }
}
