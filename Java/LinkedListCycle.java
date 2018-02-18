/* Leetcode Problem 141.

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        
        ListNode one = head;
        ListNode two = head;

        while(two != null && two.next != null){
            one = one.next;
            two = two.next.next;
            if(one == two)
                return true;
        }
        return false;
    }
}
