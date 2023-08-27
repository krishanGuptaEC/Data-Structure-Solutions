import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>(); // To store indices of histogram bars
        int maxArea = 0; // To store the maximum area of a rectangle
        
        for (int i = 0; i <= A.size(); i++) {
            int height = (i == A.size()) ? 0 : A.get(i); // Current histogram bar height
            
            // Check if the current bar's height is greater than the bar at the top of the stack
            // If not, pop elements from the stack and calculate the area until a shorter bar is encountered
            while (!stack.isEmpty() && height < A.get(stack.peek())) {
                int h = A.get(stack.pop()); // Height of the popped bar
                int w = stack.isEmpty() ? i : i - stack.peek() - 1; // Width of the rectangle
                maxArea = Math.max(maxArea, h * w); // Calculate and update the maximum area
            }
            
            stack.push(i); // Push the current bar's index onto the stack
        }
        
        return maxArea;
    }
}
