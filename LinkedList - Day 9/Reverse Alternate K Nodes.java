/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B) {
        ListNode temp = A, newNode = null, last = null;
        
        while (temp != null) {
            ListNode curr = null, pre = null, temp1 = temp;
            int count = 0;
            
            // Reverse every B nodes
            while (temp != null && count < B) {
                curr = temp;
                temp = temp.next;
                curr.next = pre;
                pre = curr;
                count++;
            }
            
            temp1.next = temp;  // Update the next of the last node of the reversed part
            
            if (newNode == null) {
                newNode = pre;   // Update the head of the new linked list
            } else {
                last.next = pre;  // Update the next of the last node of the previous part to point to the new reversed part
            }
            
            if (temp == null) {
                return newNode;   // If there are no more nodes, return the new linked list
            }
            
            count = 1;
            while (count < B) {
                temp = temp.next;  // Move to the next B nodes
                count++;
            }
            last = temp;  // Update the 'last' pointer for the next iteration
            temp = temp.next;  // Move to the next node for the next iteration
        }
        
        return newNode;  // Return the new linked list with reversed parts
    }
}
