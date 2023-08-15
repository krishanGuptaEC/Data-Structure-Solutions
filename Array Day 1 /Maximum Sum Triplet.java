public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        
        // Create an array to store maximum values from the current index to the end
        int[] maxima = new int[n];
        
        // Calculate maximum values from each index to the end of the array
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1)
                maxima[i] = A[i]; // For the last element, the maximum value is the element itself
            else
                maxima[i] = Math.max(maxima[i + 1], A[i]); // For other elements, calculate the maximum between the current element and the previous maximum
        }
        
        // Create a TreeSet to store unique values in sorted order
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1); // Add -1 to handle edge cases
        
        set.add(A[0]); // Add the first element of the array to the set
        int ans = 0; // Initialize the variable to store the answer
        
        // Iterate through the array elements (except the first and last)
        for (int i = 1; i < n - 1; i++) {
            // Check if the element is greater than the largest smaller element in the set and the maximum value in the remaining array
            if (set.lower(A[i]) != -1 && maxima[i + 1] > A[i]) {
                // Calculate the sum of the largest smaller element, the current element, and the maximum value in the remaining array
                ans = Math.max(set.lower(A[i]) + A[i] + maxima[i + 1], ans);
            }
            // Add the current element to the set
            set.add(A[i]);
        }
        
        return ans; // Return the maximum sum obtained
    }
}
