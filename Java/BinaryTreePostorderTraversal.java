/* Leetcode Problem 145.

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3
 

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        
        while(root != null || !stack.empty()){
            
            while(root != null){
                stack.push(root);
                set.add(root);
                root = root.left;
            }
            
            root = stack.peek();
            
            if(set.contains(root)){
                set.remove(root);
                root = root.right;
            }
            else{
                list.add(root.val);
                stack.pop();
                root = null;
            }
        }
        return list;
    }
}
