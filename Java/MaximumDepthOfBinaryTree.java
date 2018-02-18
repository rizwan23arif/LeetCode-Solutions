/* Leetcode Problem 104.

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

public class MaximumDepthOfBinaryTree {
    int maxDepth = 0;
    int depth = 1;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        max(root);
        return maxDepth;
    }
    public void max(TreeNode root){
        if(root.left != null){
            depth++;
            if(depth > maxDepth)
                maxDepth = depth;
            max(root.left);
        }
        if(root.right != null){
            depth++;
            if(depth > maxDepth)
                maxDepth = depth;
            max(root.right);
        }
        depth--;
    }
}
