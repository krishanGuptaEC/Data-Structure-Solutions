class Solution {
    // Initialize a stack to store Pair objects
    Stack<Pair> st = new Stack<>();
    int min = Integer.MAX_VALUE; // Initialize the minimum to maximum possible value

    // Pushes an element onto the stack
    public void push(int x) {
        min = Math.min(min, x); // Update the minimum element seen so far
        st.add(new Pair(x, min)); // Add a new Pair containing the element and current minimum
    }

    // Pops an element from the stack
    public void pop() {
        if (!st.isEmpty()) {
            st.pop(); // Remove the top Pair from the stack
            if (!st.isEmpty())
                min = st.peek().min; // Update the minimum to the minimum of the remaining stack
            else
                min = Integer.MAX_VALUE; // If the stack becomes empty, reset minimum to maximum
        }
    }

    // Returns the top element of the stack
    public int top() {
        if (st.isEmpty())
            return -1; // Return -1 if the stack is empty
        return st.peek().ele; // Return the element stored in the top Pair
    }

    // Returns the minimum element in the stack
    public int getMin() {
        if (st.isEmpty())
            return -1; // Return -1 if the stack is empty
        return st.peek().min; // Return the minimum stored in the top Pair
    }
}

// Custom Pair class to hold an element and its corresponding minimum
class Pair {
    int ele; // The element
    int min; // The minimum element seen so far

    // Constructor to initialize the Pair with element and minimum
    Pair(int ele, int min) {
        this.ele = ele;
        this.min = min;
    }
}
