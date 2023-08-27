public class Solution {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int k) {
        ArrayList<Integer> list = new ArrayList<>(); // To store the maximum values for each window
        Deque<Integer> q = new LinkedList<>(); // A deque to store indices of elements in the window
        int i = 0; // Start of the current window
        int j = 0; // End of the current window
        
        while (j < A.size()) {
            if (q.size() > 0) {
                // Remove elements from the back of the deque that are smaller than the current element
                while (q.size() > 0 && q.getLast() < A.get(j)) {
                    q.removeLast();
                }
                q.addLast(A.get(j)); // Add the current element to the back of the deque
            } else {
                q.addFirst(A.get(j)); // Add the current element to the front of the deque
            }
            
            if (j - i + 1 < k) {
                j++; // Expand the window
            } else if (j - i + 1 == k) {
                list.add(q.getFirst()); // The front of the deque contains the maximum value in the current window
                
                // If the element at the start of the window is the same as the front of the deque,
                // remove it from the deque as it will no longer be in the next window
                if (A.get(i) == q.getFirst()) {
                    q.removeFirst();
                }
                
                i++; // Move the window by incrementing the start index
                j++; // Expand the window by incrementing the end index
            }
        }
        
        return list; // Return the list containing maximum values for each window
    }
}
