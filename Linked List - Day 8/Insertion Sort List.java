public class Solution {
    public ListNode insertionSortList(ListNode A) {
        // Create a dummy node to simplify insertion
        ListNode prev = null, cur = A, head = new ListNode(Integer.MIN_VALUE), next = null;
        prev = head;  // Initialize 'prev' to the dummy node
        ListNode temp = head;  // Initialize 'temp' to the dummy node
        while(cur != null) {
            temp = head;  // Reset 'temp' to the dummy node for each iteration
            next = cur.next;  // Store the next node before modifying 'cur'
            iinsert(head, cur);  // Call the insertion function
            cur = next;  // Move 'cur' to the next node for the next iteration
        }
        return head.next;  // Return the sorted linked list (excluding the dummy node)
    }
        
    public static void iinsert(ListNode head, ListNode in) {
        ListNode temp = head, prev = null;
        while(temp != null) {
            if(temp.val > in.val) {
                // Insert 'in' node before 'temp' node
                prev.next = in;
                in.next = temp;
                return;  // Exit the function after insertion
            }
            prev = temp;  // Update 'prev' to the current node
            temp = temp.next;  // Move 'temp' to the next node
        }
        // If 'in' is greater than all existing nodes, insert it at the end
        prev.next = in;
        in.next = null;
        return;  // Exit the function
    }
}
