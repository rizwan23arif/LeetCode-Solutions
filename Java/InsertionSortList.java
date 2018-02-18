/* Leetcode Problem 147.

Sort a linked list using insertion sort.
*/

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
            
        ListNode curr = head.next;
        ListNode prev = head;
        
        while(curr != null){
            
            while(prev != curr){
                
               if(prev.val > curr.val){
                   int temp = prev.val;
                   prev.val = curr.val;
                   curr.val = temp;
               }
               prev = prev.next;
            }
            prev = head;
            curr = curr.next;
        }
        return head;
    }
}
