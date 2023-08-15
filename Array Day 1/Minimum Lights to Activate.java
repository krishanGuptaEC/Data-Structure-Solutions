public class Solution {
    public int solve(int[] A, int B) {
        int ans = 0;        // Initialize a variable to store the answer
        int n = A.length;   // Get the length of array A
        int i = 0;          // Initialize a variable for iteration
        
        // Loop through the array A
        while (i < n) {
            // Calculate the range of indices to check for bulbs
            int l = Math.max(0, i - B + 1);
            int r = Math.min(n - 1, i + B - 1);
            boolean bulb_found = false;  // Flag to indicate if a bulb is found
            
            // Loop through the range of indices in reverse order
            for (int j = r; j >= l; j--) {
                if (A[j] == 1) {  // Check if the bulb is turned on
                    bulb_found = true;  // Set the flag to true
                    ans++;  // Increment the answer count
                    i = j + B;  // Move the current index to a position after the found bulb
                    break;  // Exit the loop
                }
            }
            
            // If no bulb is found in the range, return -1
            if (!bulb_found) {
                return -1;
            }
        }
        return ans;  // Return the final answer count
    }
}

