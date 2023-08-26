/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        // Create a HashMap to keep track of the frequency of each value
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the linked list to populate the HashMap
        ListNode temp = A;
        while (temp != null) {
            if (map.containsKey(temp.val)) {
                // If value is already in the map, increment its frequency
                Integer k = map.get(temp.val) + 1;
                map.replace(temp.val, k);
            } else {
                // If value is not in the map, add it with frequency 1
                map.put(temp.val, 1);
            }
            temp = temp.next; // Move to the next node
        }
        
        temp = A;
        ListNode head = null;
        ListNode tail = null;
        
        // Iterate through the linked list again to create a new linked list
        while (temp != null) {
            if (map.get(temp.val) > 1) {
                // If value has a frequency greater than 1, skip this node (delete duplicate)
                temp = temp.next;
            } else {
                // If value is unique, create a new node and add it to the new linked list
                ListNode newNode = new ListNode(temp.val);
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    tail.next = newNode;
                    tail = tail.next;
                }
                temp = temp.next;
            }
        }
        
        return head; // Return the head of the new linked list containing only unique elements
    }
}
