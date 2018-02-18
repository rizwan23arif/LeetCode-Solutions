/* Leetcode Problem 230.

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the 
kthSmallest routine?
*/

public class KthSmallestElementInaBST {
    int count = 0;
    boolean firstLeaf = false;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
            
        if(root.left == null && firstLeaf == false)
            firstLeaf = true;
                
        int a = kthSmallest(root.left, k);
        
        if(firstLeaf == true)
            count++;
        if(count == k)
            return root.val;
        
        if (a==-1)
            a = kthSmallest(root.right, k);
        
        return a;
    
    }
}
