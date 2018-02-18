/* Leetcode Problem 515.

You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

public class LargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        return list;
    }
    
    public void helper(TreeNode root, int depth, List<Integer> list){
        
        if(root == null)
            return ;
            
        if(list.size() == depth)
            list.add(root.val);
        else{
            if(list.get(depth) < root.val)
                list.set(depth,root.val);
        }
            
        helper(root.left, 1+depth, list);
        helper(root.right, 1+depth, list);
    }
}
