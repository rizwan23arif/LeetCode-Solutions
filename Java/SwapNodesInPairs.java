/* Leetcode Problem 24.

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        
        while(head != null && head.next != null){
            ListNode inter = head.next;
            ListNode forward = inter.next;
            inter.next = head;
            head.next = forward;
            prev.next = inter;
            prev = head;
            head = forward;
        }
        return dummy.next;
    }
}
