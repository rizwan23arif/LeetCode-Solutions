/* Leetcode Problem 92.

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        int i=1;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = head;
        
        while(i != m){
            first = first.next;
            second = second.next;
            i++;
        }
        
        ListNode prev = second;
        ListNode curr = prev.next;
        
        while(i != n){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
            i++;
        }
        
        first.next = prev;
        second.next = curr;
        
        if(m==1)
            return first.next;
            
        return head;
    }
}
