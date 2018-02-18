/* Leetcode Problem 142.

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

public class LinkedListCycleII {
        public ListNode detectCycle(ListNode head) {
          ListNode slow = head, fast = head;
          while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
              while (head != slow) {
                head = head.next;
                slow = slow.next;
              }
              return slow;				
            }
          }			
          return null;
        }
}
