/* Leetcode Problem 129.

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class SumRootToLeafNumbers {
    
    int i=0;
    
    public int sumNumbers(TreeNode root) {
        leaf(root, 0);
        return i;
    }
    
    public void leaf(TreeNode root, int prev){
        if(root == null)
            return ;
            
        int newVal = prev * 10 + root.val;
        
        if(root.left == root.right)
            i += newVal;
            
        leaf(root.left, newVal);
        leaf(root.right, newVal);
    }
}
