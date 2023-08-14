public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;  // Get the length of the input array A
        int i = 0;         // Initialize a pointer i for iterating through the array
        int j = 0;         // Initialize a pointer j for finding the position to swap with
        
        // Loop through the array A
        while (i < n) {
            // Check if the current element is non-zero
            if (A[i]!= 0) {
                // Find the next available position with a zero element
                while (j < i && A[j] != 0) {
                    j++;
                }
                
                // If j reaches the end of the array, all non-zero elements are in place
                if (j == n) {
                    return A;
                } else if (A[j] == 0) {
                    // Swap the non-zero element with the zero element at position j
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
            i++;  // Move the i pointer to the next element
        }
        
        return A;  // Return the modified array after moving zeroes to the end
    }
}
