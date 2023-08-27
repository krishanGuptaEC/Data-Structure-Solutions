public class Solution {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> res = new ArrayList<Integer>(); // To store the gray code sequence
        
        if (a == 0) {
            return res; // For a = 0, return an empty list
        }
        
        res.add(0); // Initialize the gray code sequence with the first element
        res.add(1); // Add the second element
        
        if (a == 1) {
            return res; // For a = 1, return the gray code sequence [0, 1]
        }
        
        // Generate the gray code sequence for larger values of 'a'
        while (a-- > 1) { // Repeat 'a' times
            int n = res.size(); // Get the current size of the gray code sequence
            
            // Iterate through the existing gray code sequence in reverse order
            for (int i = n - 1; i >= 0; i--) {
                // Add the next element to the gray code sequence by appending 'n' to the existing elements
                res.add(n + res.get(i));
            }
        }
        
        return res; // Return the generated gray code sequence
    }
}
