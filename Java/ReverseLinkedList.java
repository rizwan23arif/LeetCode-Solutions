/* Leetcode Problem 206.

Reverse a singly linked list.
*/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode forward = head.next;
            head.next = newHead;
            newHead = head;
            head = forward;
        }
        return newHead;
    }
}
