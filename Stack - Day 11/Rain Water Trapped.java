public class Solution {
    public int trap(final int[] height) {
        int l = 0; // Pointer for the leftmost side of the array
        int r = height.length - 1; // Pointer for the rightmost side of the array
        int leftMax = height[l]; // Initialize the maximum height from the left
        int rightMax = height[r]; // Initialize the maximum height from the right
        int rain = 0; // To store the total trapped rainwater
        
        // Loop until the left and right pointers meet
        while (l < r) {
            if (leftMax < rightMax) {
                l++; // Move the left pointer to the right
                leftMax = Math.max(leftMax, height[l]); // Update the maximum height from the left
                rain += leftMax - height[l]; // Calculate the trapped rainwater on the left side
            } else {
                r--; // Move the right pointer to the left
                rightMax = Math.max(rightMax, height[r]); // Update the maximum height from the right
                rain += rightMax - height[r]; // Calculate the trapped rainwater on the right side
            }
        }
       
        return rain; // Return the total trapped rainwater
    }
}
