/* Leetcode Problem 653.

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        
        int start = 0;
        int end = list.size()-1;
        
        while(start < end){
            int sum = list.get(start) + list.get(end);
            if(sum == k)
                return true;
            else if(sum < k)
                start++;
            else
                end--;
        }
        return false;
            
    }
    
    public void inOrder(TreeNode root, List<Integer> list){
        
        if (root == null)
            return;
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);   
        
    }

}
