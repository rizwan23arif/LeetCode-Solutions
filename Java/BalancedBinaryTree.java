/* Leetcode Problem 110.

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        
         return height(root, 1) != -1;
        
    }
    public int height(TreeNode root, int height) {

        if (root==null)
            return height;
        
        int left = height(root.left, height+1);
        int right = height(root.right, height+1);

        return Math.abs(left-right) > 1 ? -1 : Math.max(left,right);
    }
}
