/* Leetcode Problem 144.

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.empty()){
            
            while(root != null){
                
                stack.add(root);
                list.add(root.val);
                root = root.left;
            }
            
            root = stack.peek();
            root = root.right;
            stack.pop();
            
        }
        
        return list;
    }
}
