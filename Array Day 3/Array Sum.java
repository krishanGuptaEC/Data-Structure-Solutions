public class Solution {
    public int[] addArrays(int[] A, int[] B) {
        // Get the lengths of the input arrays
        int n = A.length;
        int m = B.length;
        
        // If the length of array B is greater than A, swap A and B and recursively call the function
        if(m > n) return addArrays(B, A);
        
        // Initialize pointers for A and B arrays and a carry variable
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        
        // Iterate through both arrays and perform addition along with carry handling
        while(i >= 0 && j >= 0){
            int temp = A[i] + B[j] + carry;
            if(temp >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            A[i] = temp % 10;
            i--;
            j--;
        }
        
        // Handle remaining digits in A, if any
        while(i >= 0){
            int temp = A[i] + carry;
            if(temp >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            A[i] = temp % 10;
            i--;
        }
        
        // If there's still a carry left, create a new array to accommodate it
        if(carry != 0) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            for(i = 0; i < n; i++){
                ans[i + 1] = A[i];
            }
            return ans;
        }
        
        // If no additional carry, return the modified A array
        return A;
    }
}
