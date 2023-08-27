public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> sol = new ArrayList<>(); // To store solutions
        int ar[] = new int[a]; // Array to store the positions of queens
        
        // Start the helper function to find solutions
        helper(a, ar, 0, sol);
        
        return sol; // Return the list of solutions
    }
    
    // Helper function to find solutions for N-Queens problem
    private static void helper(int a, int[] ar, int it, ArrayList<ArrayList<String>> sol) {
        // Base case: if all queens are placed, generate a solution
        if (it >= a) {
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                String str = "";
                for (int j = 0; j < a; j++) {
                    if (j == ar[i]) {
                        str += "Q"; // Place a queen at the specified position
                    } else {
                        str += ".";
                    }
                }
                temp.add(str); // Add the row to the temporary list
            }
            sol.add(new ArrayList<>(temp)); // Add the temporary list to the solution list
            return;
        }
        
        // Try placing the queen in each column of the current row
        for (int i = 0; i < a; i++) {
            if (isInCheck(ar, i, it)) { // Check if the placement is valid
                ar[it] = i; // Place the queen and move to the next row
                helper(a, ar, it + 1, sol); // Recur for the next row
            }
        }
    }
    
    // Function to check if placing a queen in a given position is valid
    private static boolean isInCheck(int[] ar, int n, int it) {
        // Check if the same column is occupied by a queen in a previous row
        for (int i = it - 1; i >= 0; i--) {
            if (n == ar[i]) {
                return false;
            }
        }
        
        // Check if the diagonal in the upper left direction is safe
        int c = 1;
        for (int i = it - 1; i >= 0; i--) {
            if (n - c < 0) {
                break;
            }
            if (n - c == ar[i]) {
                return false;
            }
            c++;
        }
        
        // Check if the diagonal in the upper right direction is safe
        c = 1;
        for (int i = it - 1; i >= 0; i--) {
            if (n + c >= ar.length) {
                break;
            }
            if (n + c == ar[i]) {
                return false;
            }
            c++;
