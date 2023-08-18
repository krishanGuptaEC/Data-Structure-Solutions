public class Solution {
    // Helper function to check if books can be distributed with a maximum number of pages per student
    public boolean solve(int[] A, int B, int x) {
        int n = A.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > x) return false; // If any book's pages are greater than x, distribution is not possible
            else if (temp + A[i] > x) {
                temp = A[i]; // Reset temp and assign the current book's pages
                B--;         // Decrease the number of students left
            } else {
                temp += A[i]; // Add the current book's pages to temp
            }
        }
        return B > 0; // Return true if all books can be distributed with the given x
    }
    
    // Function to find the minimum maximum pages per student for fair book distribution
    public int books(int[] A, int B) {
        int n = A.length;
        int low = A[0];
        int high = low;
        for (int i = 1; i < n; i++) {
            low = Math.max(low, A[i]); // Find the maximum element in the array
            high += A[i];              // Calculate the total sum of the array
        }
        if (B > n) return -1; // If students are more than books, distribution is not possible
        if (n == B) return low; // Each student gets one book
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (solve(A, B, mid)) {
                ans = mid;      // Update the answer and search for lower values
                high = mid - 1;
            } else {
                low = mid + 1;   // Search for higher values
            }
        }
        return ans; // Return the minimum maximum pages per student
    }
}
