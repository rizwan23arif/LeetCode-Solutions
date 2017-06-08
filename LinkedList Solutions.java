1.*** PROBLEM 237: DELETE NODE IN A LINKED LIST ***
EXPLANATION: Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
TIME COMPLEXITY: O(constant)

public class Solution {
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2.*** PROBLEM 234. Palindrome Linked List ***
EXPLANATION: Given a singly linked list, determine if it is a palindrome.
TIME COMPLEXITY: O(n)

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. *** 206. Reverse Linked List ***

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. *** 203. Remove Linked List Elements ***
EXPLANATION: Remove all elements from a linked list of integers that have value val.

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode current = head;
        while(current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            }
            else
                current = current.next;
        }
        if(head.val == val)
            return head.next;
        else
            return head;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. *** 160. Intersection of Two Linked Lists ***
EXPLANATION: Write a program to find the node at which the intersection of two singly linked lists begins.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
        int lengthA = 0;
        int lengthB = 0;
		
        ListNode current = headA;
		
        while(current != null){
            lengthA++;
            current = current.next;
        }
		
        current = headB;
		
        while(current != null){
            lengthB++;
            current = current.next;
        }
		
        int diff = Math.abs(lengthA - lengthB);
		
        while(diff != 0){
            if(lengthA > lengthB)
                headA = headA.next;
            else
                headB = headB.next;
            diff--;
        }
		
        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. *** 147. Insertion Sort List ***
EXPLANATION: Sort a link list using Insertion sort

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. *** 141. Linked List Cycle ***
EXPLANATION: Given a linked list, determine if it has a cycle in it.

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. *** 142. Linked List Cycle II ***
EXPLANATION: Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. *** 92. Reverse Linked List II ***
EXPLANATION: Reverse a linked list from position m to n. Do it in-place and in one-pass.

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. *** 83. Remove Duplicates from Sorted List ***
EXPLANATION: Given a sorted linked list, delete all duplicates such that each element appear only once.

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;
         
         while(list != null) {
        	 if (list.next == null) {
        		 break;
        	 }
        	 if (list.val == list.next.val) {
        		 list.next = list.next.next;
        	 } else {
        		 list = list.next;
        	 }
         }
         
         return head;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11. *** 19. Remove Nth Node From End of List ***

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null || head.next == null)
            return null;
            
        ListNode first = head;
        ListNode second = head;
        
        while(n > 0){
            second = second.next;
            n--;
        }
        
        if(second == null)
            return head.next;
            
        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        
        first.next = first.next.next;
        return head;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
12. *** 24. Swap Nodes in Pairs ***
EXPLANATION: Given a linked list, swap every two adjacent nodes and return its head.

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
13. *** 21. Merge Two Sorted Lists ***

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3.next = l1;
                l1 = l1.next;
            }
            else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if(l1 == null)
            l3.next = l2;
        if(l2 == null)
            l3.next = l1;
        
        return head.next;
    }
}
