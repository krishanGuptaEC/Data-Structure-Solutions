public class Solution {
    // Helper function to reverse a linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    
    // Function to check if a linked list is a palindrome
    public int lPalin(ListNode head) {
        // Initialize two pointers, slow and fast, both pointing to the head
        ListNode slow = head;
        ListNode fast = head;
        
        // Find the middle of the linked list using the two-pointer approach
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1 step
            fast = fast.next.next;    // Move fast pointer by 2 steps
        }
        
        // Reverse the second half of the linked list
        ListNode secondHalf = reverseLinkedList(slow);
        ListNode firstHalf = head;   // The firstHalf pointer still points to the start of the original list
        
        // Compare elements of the first half and the reversed second half
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return 0; // If values are not equal, the list is not a palindrome
            }
            firstHalf = firstHalf.next;     // Move firstHalf pointer forward
            secondHalf = secondHalf.next;   // Move secondHalf pointer forward
        }
        
        return 1; // If all values matched, the list is a palindrome
    }
}
