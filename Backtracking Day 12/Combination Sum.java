public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A); // Sort the input array in ascending order
        Set<ArrayList<Integer>> sol = new LinkedHashSet<>(); // To store unique combinations
        ArrayList<Integer> temp = new ArrayList<>(); // To store the current combination
        
        // Start the helper function with initial index 0
        helper(A, B, sol, temp, 0);
        
        ArrayList<ArrayList<Integer>> ansfinal = new ArrayList<>();
        for (ArrayList<Integer> i : sol) {
            ansfinal.add(i); // Convert the set to an array list for the final result
        }

        return ansfinal; // Return the list of unique combinations
    }

    private void helper(ArrayList<Integer> a, int b, Set<ArrayList<Integer>> sol, ArrayList<Integer> temp, int i) {
        // Base cases
        if (i >= a.size() || b < 0) {
            return; // If index exceeds array size or b becomes negative, stop recursion
        }
        
        if (b == 0) {
            sol.add(new ArrayList<>(temp)); // If b becomes 0, add the current combination to the set
            return;
        }
        
        // Include the current element and move to the next recursive call
        temp.add(a.get(i));
        helper(a, b - a.get(i), sol, temp, i);
        temp.remove(temp.size() - 1); // Backtrack: remove the last added element
        
        // Exclude the current element and move to the next recursive call
        helper(a, b, sol, temp, i + 1);
    }
}
