public class Solution {
    public int braces(String A) {
        int ans = 0; // This will store the final result (0 or 1) indicating if braces are balanced
        Stack<Character> s = new Stack<>(); // Creating a stack to store characters
        
        A = A.trim(); // Removing leading and trailing whitespace from the input string
        int l = A.length(); // Getting the length of the input string
        
        for (int i = 0; i < l; i++) {
            char c = A.charAt(i); // Getting the character at position i in the input string
            int t = 0; // This will be used to count the number of characters between matching braces
            
            // Checking for a case where there's an unnecessary pair of braces "()"
            if (c == '(' && i + 2 < l && A.charAt(i + 2) == ')')
                return 1; // If such a case is found, we immediately return 1 (indicating unnecessary braces)
            
            if (c == ')') {
                // Handling the case where we encounter a closing parenthesis ")"
                while (!s.empty() && s.peek() != '(') {
                    s.pop(); // Pop characters from the stack until we find an opening parenthesis "("
                    t++; // Increment the count of characters between matching braces
                }
                s.pop(); // Remove the opening parenthesis "(" from the stack
                if (t == 0)
                    return 1; // If t is 0, this means there were no characters between the braces, indicating unnecessary braces
            } else {
                s.push(c); // Push the character onto the stack if it's not a closing parenthesis ")"
            }
        }
        
        // After processing all characters, check if there's an opening parenthesis "(" left in the stack
        if (!s.empty() && s.peek() == '(')
            return 1; // If there's an opening parenthesis left in the stack, it means there are unmatched braces
        
        return 0; // If the stack is empty and there are no unnecessary pairs, then braces are balanced
    }
}
