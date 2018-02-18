/* Leetcode Problem 105.

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

public class ConstructFromPreorderAndInorderTraversal {
    
    int preOrderIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);    
        
        return buildTreeHelper(inorder, preorder, map, 0, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] inorder, int[] preorder, Map<Integer, Integer> map, int index, int start, int end){
        
        if(preOrderIndex > preorder.length-1)
            return null;
            
        int searchVal = preorder[preOrderIndex];
        index = map.get(searchVal);
        
        if (index < start || index > end)
            return null;
        
        preOrderIndex++;

        TreeNode root = new TreeNode(searchVal);

        root.left = buildTreeHelper(inorder, preorder, map, index, start, index-1);
        root.right = buildTreeHelper(inorder, preorder, map, index, index+1, end );

        return root;

    }
}
