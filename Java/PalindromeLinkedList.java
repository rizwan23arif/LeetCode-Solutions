/* Leetcode Problem 234.

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
TIME COMPLEXITY: O(n)
*/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
            
        ListNode curr = head;
        ListNode mid = head;
        
        while(curr != null && curr.next != null){
            curr = curr.next.next;
            mid = mid.next;
        }
        
        curr = mid.next;
        ListNode prev = mid;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        mid.next = null;
        
        curr = head;
        while(prev != null && prev != curr){
            if(prev.val != curr.val)
                return false;
            prev = prev.next;
            curr = curr.next;
        }
        return true;
    }
}
