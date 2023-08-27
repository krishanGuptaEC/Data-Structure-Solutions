import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String solve(String A) {
        int[] count = new int[26]; // To store the frequency of characters
        Queue<Character> queue = new LinkedList<>(); // To maintain the order of characters
        
        StringBuilder result = new StringBuilder(); // To store the final result
        
        for (char c : A.toCharArray()) {
            count[c - 'a']++; // Increment the count of the current character
            
            // Add the current character to the queue if its count is 1 (first occurrence)
            if (count[c - 'a'] == 1) {
                queue.offer(c);
            }
            
            // Remove characters from the queue that are no longer non-repeating
            while (!queue.isEmpty() && count[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            
            // Append the first non-repeating character to the result
            if (!queue.isEmpty()) {
                result.append(queue.peek());
            } else {
                result.append('#'); // If no non-repeating character is found, append '#'
            }
        }
        
        return result.toString();
    }
}
