public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<Character>[] digits;
        digits = new ArrayList[10]; // Array of ArrayLists for storing digit-to-letter mappings
        
        for (int i = 0; i < 10; i++) {
            digits[i] = new ArrayList<>(); // Initialize each ArrayList
        }
        
        digits[0].add('0'); // Mapping for digit 0
        digits[1].add('1'); // Mapping for digit 1
        
        char c = 'a'; // Starting letter for mapping
        int k;
        
        // Generate mappings for digits 2 to 9 based on phone keypad layout
        for (int i = 2; i < 10; i++) {
            k = 3; // Default number of letters for most digits
            if (i == 7 || i == 9)
                k = 4; // Digits 7 and 9 have 4 letters
            
            for (int j = 0; j < k; j++) {
                digits[i].add(c); // Add the current letter to the digit mapping
                c++;
            }
        }
        
        int i = 0;
        int n = A.length();
        ArrayList<String> res = new ArrayList<>(); // To store the resulting letter combinations
        ArrayList<String> temp = new ArrayList<>(); // Temporary list for generating combinations
        ArrayList<String> x; // Temporary list for swapping
        
        res.add(""); // Start with an empty string in the result
        
        while (i < n) {
            int dig = A.charAt(i) - '0'; // Convert the current digit character to an integer
            
            // Generate combinations by appending letters to each existing combination
            for (String str : res) {
                for (char ch : digits[dig]) {
                    String st = str + ch; // Append the letter to the existing combination
                    temp.add(st); // Add the new combination to the temporary list
                }
            }
            
            // Swap res and temp to update the result and clear the temporary list
            x = res;
            res = temp;
            temp = x;
            temp.clear();
            
            i++; // Move to the next digit in the input string
        }
        
        return res; // Return the final list of letter combinations
    }
}
