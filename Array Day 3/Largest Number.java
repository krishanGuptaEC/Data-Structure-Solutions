public class Solution {
    public String largestNumber(final int[] A) {
        int n = A.length;
        
        // If there's only one element, return it as a string
        if (n == 1) return Integer.toString(A[0]);
        
        int count = 0;
        // Count the number of zeros in the array
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) count++;
        }
        
        // If all elements are zeros or the array is empty, return "0"
        if (count == n || n == 0) return "0";
        
        // Convert the integer array to a string array
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.toString(A[i]);
        }
        
        // Sort the string array using a custom comparator
        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));
        
        // Join the sorted string array to form the largest possible number
        String ans = String.join("", temp);
        
        return ans;
    }
}
