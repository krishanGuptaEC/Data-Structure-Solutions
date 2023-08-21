public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode temp = A;   // Initialize a temporary pointer 'temp' to the head of the linked list 'A'
        ListNode par = null; // Initialize 'par' to keep track of the previous node while traversing
        ListNode pos = null; // Initialize 'pos' to keep track of the last node with value less than 'B'
        
        // First loop: Move 'pos' and 'par' to the right position where values are less than 'B'
        while (temp != null && temp.val < B) {
            pos = temp;  // Update 'pos' to the current node
            par = temp;  // Update 'par' to the current node
            temp = temp.next; // Move 'temp' to the next node
        }

        // Second loop: Partition the list based on the value 'B'
        while (temp != null) {
            if (temp.val >= B) {
                par = temp;  // Update 'par' to the current node
                temp = temp.next; // Move 'temp' to the next node
            } else {
                ListNode t = temp; // Create a new pointer 't' to the current node
                temp = t.next;     // Move 'temp' to the next node
                par.next = temp;   // Update the 'next' pointer of 'par' to skip the current node
                
                if (pos == null) {
                    t.next = A;     // If 'pos' is null, insert 't' at the beginning
                    A = t;          // Update 'A' to the new head
                } else {
                    t.next = pos.next; // Insert 't' after 'pos'
                    pos.next = t;      // Update 'pos.next' to point to 't'
                }
                pos = t; // Update 'pos' to the newly inserted node 't'
            }
        }

        return A; // Return the modified linked list
    }
}
