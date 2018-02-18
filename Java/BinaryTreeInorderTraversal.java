/* Leetcode Problem 94.

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
            
        while(root != null || !stack.empty()){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            list.add(root.val);
            root = root.right;
                
        }
        return list;
    }
}
