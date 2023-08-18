public class Solution {
    // Function to compute the integer square root of A
    public int sqrt(int A) {
        if (A == 0) return 0; // Square root of 0 is 0
        if (A == 1) return 1; // Square root of 1 is 1

        int i = 1; // Initialize i to 1
        int temp = A; // Initialize a variable temp to A

        // Loop to find the largest i such that temp - 2*i + 1 >= 0
        while (temp - 2 * i + 1 >= 0) {
            temp = temp - 2 * i + 1; // Decrement temp by the difference
            i++; // Increment i
        }
        return i - 1; // Return the integer square root (i - 1)
    }
}
