import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(); // To store the final subsets
        ArrayList<Integer> current = new ArrayList<>(); // To store the current subset
        
        // Start with an empty subset
        result.add(new ArrayList<>(current));
        
        generateSubsets(A, 0, current, result); // Generate subsets recursively
        
        return result;
    }
    
    private void generateSubsets(ArrayList<Integer> A, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (index == A.size()) {
            return; // Base case: end of array
        }
        
        for (int i = index; i < A.size(); i++) {
            current.add(A.get(i)); // Include the current element in the subset
            result.add(new ArrayList<>(current)); // Add the subset to the result
            
            generateSubsets(A, i + 1, current, result); // Recur for the next elements
            
            current.remove(current.size() - 1); // Backtrack: remove the last added element
        }
    }
}
