public class Solution {
    public int paint(int A, int B, ArrayList<Integer> C) {
        
        long start = 0; // Initialize the lower bound of search space
        long end = 0;   // Initialize the upper bound of search space
        
        // Loop to find the maximum and total time needed for all boards
        for (int i = 0; i < C.size(); i++) {
            start = Math.max(start, C.get(i)); // Update start with the maximum board time
            end += C.get(i);                   // Accumulate the total time for all boards
        }

        // Binary search to find the minimum time needed for painting
        while (start < end){
            
            long pieces = 1;     // Initialize the number of pieces painted
            long sum = 0;        // Initialize the accumulated time for a piece
            long middle = start + (end - start) / 2; // Calculate the middle time

            // Loop through the boards to count the pieces and accumulate time
            for (int i = 0; i < C.size(); i++) {
                if (sum + C.get(i) > middle) {
                    pieces++;   // Increment pieces if accumulated time exceeds the middle
                    sum = C.get(i); // Reset sum for a new piece
                } else {
                    sum += C.get(i); // Accumulate time for the current piece
                }
            }
            
            // Adjust the search range based on the number of pieces
            if (pieces > A) {
                start = middle + 1; // Search in the higher time range
            } else {
                end = middle;       // Search in the lower time range
            }
        }
        
        // Calculate the final answer and return it modulo 10000003
        long ans = (end * B) % 10000003;
        
        return (int) ans; // Convert the answer to int and return
    }
}
