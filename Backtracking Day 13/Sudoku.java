public class Solution {
    private int n; // The size of the board (typically 9)
    private ArrayList<ArrayList<Character>> A; // The Sudoku board
    private HashSet<Character> hashSet; // To keep track of seen characters for validation
    
    public void solveSudoku(ArrayList<ArrayList<Character>> A) {
        n = A.size(); // Initialize the size of the board
        this.A = A; // Store the Sudoku board
        hashSet = new HashSet<>(); // Initialize the hashSet for validation
        backtrack(0, 0); // Start solving the Sudoku puzzle
    }
    
    // Backtracking function to solve the Sudoku puzzle
    public boolean backtrack(int row, int col) {
        if (row == n)
            return true; // If we reach the end of the board, the puzzle is solved
        
        char c = A.get(row).get(col);
        int rr, cc;
        rr = row;
        cc = col + 1;
        
        if (cc == n) {
            rr++;
            cc = 0;
        }
        
        if (c == '.') {
            // Try placing digits 1 to 9 in the empty cell
            for (char ch = '1'; ch <= '9'; ch++) {
                A.get(row).set(col, ch); // Place the digit in the cell
                
                if (isValid(row, col)) { // Check if the placement is valid
                    boolean status = backtrack(rr, cc); // Recur to the next cell
                    if (status)
                        return true; // If a valid solution is found, return true
                }
                
                A.get(row).set(col, '.'); // Backtrack: remove the digit
            }
            
        } else {
            return backtrack(rr, cc); // Move to the next cell if the current cell is filled
        }
        
        return false; // No valid solution found, backtrack
    }
    
    // Function to validate the placement of a digit in a cell
    public boolean isValid(int row, int col) {
        hashSet.clear(); // Clear the hashSet for each validation
        
        char c;
        
        // Validate the row
        for (int i = 0; i < n; i++) {
            c = A.get(row).get(i);
            if (hashSet.contains(c))
                return false; // Duplicate digit found in the same row
            if (c != '.')
                hashSet.add(c);
        }
        
        // Validate the column
        for (int i = 0; i < n; i++) {
            c = A.get(i).get(col);
            if (hashSet.contains(c))
                return false; // Duplicate digit found in the same column
            if (c != '.')
                hashSet.add(c);
        }
        
        // Validate the 3x3 subgrid
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        hashSet.clear();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int rr = sRow + i;
                int cc = sCol + j;
                c = A.get(rr).get(cc);
                
                if (hashSet.contains(c))
                    return false; // Duplicate digit found in the same subgrid
                if (c != '.')
                    hashSet.add(c);
            }
        }
        
        return true; // All validations passed
    }
}
