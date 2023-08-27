public class Solution {
    // Helper function to generate all possible palindromic partitions of a string
    void helper(String s, ArrayList<String> al, ArrayList<ArrayList<String>> all) {
        if (s.length() == 0) {
            all.add(new ArrayList<String>(al)); // Add the current partition to the result list
        }
       
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1); // Extract substring from 0 to i
           
            boolean res = isPalindromic(str); // Check if the substring is a palindrome
           
            if (res) {
                al.add(str); // Add the palindrome substring to the current partition
                helper(s.substring(i + 1), al, all); // Recur for the remaining substring
                al.remove(al.size() - 1); // Backtrack: remove the last added palindrome substring
            }
        }
    }
    
    // Main function to partition a string into palindromic substrings
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<String> al = new ArrayList<>(); // To store the current partition
        ArrayList<ArrayList<String>> all = new ArrayList<>(); // To store all partitions
       
        // Call the helper function to generate partitions
        helper(a, al, all);
        
        return all; // Return the list of all palindromic partitions
    }
   
    // Function to check if a string is palindromic
    private boolean isPalindromic(String str) {
        int left = 0;
        int right = str.length() - 1;
       
        // Check if characters at symmetric positions match
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
           
            left++;
            right--;
        }
       
        return true; // It's a palindrome
    }
}
