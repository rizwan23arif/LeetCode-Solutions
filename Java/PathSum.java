/* Leetcode Problem 112.

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the
given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class PathSum {
    
    //int sumPath = 0;
     
    public boolean hasPathSum(TreeNode root, int sum) {
        
        boolean result = helper(root, sum, 0);
        return result;
        
    }
    public boolean helper(TreeNode root, int sum, int prev){
        
        if(root == null)
            return false;
          
        int sumPath = prev + root.val;
        
        if(root.left == root.right)
            return (sumPath == sum);

        return helper(root.left, sum, sumPath) || helper(root.right, sum, sumPath);

    }
}
