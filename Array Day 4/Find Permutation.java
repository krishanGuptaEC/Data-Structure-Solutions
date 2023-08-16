public class Solution {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int min = 1;
        int max = 1;
        ans.add(1);
        
        // Loop through the pattern string A
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I') {
                ans.add(++max); // If 'I', increase max and add it to the result list
            } else {
                ans.add(--min); // If 'D', decrease min and add it to the result list
            }
        }
        
        // If min is already 1, return the generated permutation
        if (min == 1) return ans;
        
        // Adjust the permutation by adding a constant value to each element
        min = Math.abs(min); // Ensure min is a positive value
        
        for (int i = 0; i < B; i++) {
            int x = ans.get(i);
            ans.set(i, x + min + 1);
        }
        
        return ans;
    }
}
