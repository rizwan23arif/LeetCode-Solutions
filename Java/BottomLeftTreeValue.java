/* Leetcode Problem 513.

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1

Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

Note: You may assume the tree (i.e., the given root node) is not NULL.
*/

public class BottomLeftTreeValue {
    
    int value;
    int maxDepth = -1;
    
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return value;
    }
    public void helper(TreeNode root, int depth){
        if(root == null)
            return ;
        if(root.left == root.right){
            if(depth > maxDepth){
                maxDepth = depth;
                value = root.val;
            }
        }
        helper(root.left, 1+depth);
        helper(root.right, 1+depth);
    }
}

// IInd Solution: Using QueuedEvent

public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
}
