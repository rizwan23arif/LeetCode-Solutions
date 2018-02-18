/* Leetcode Problem 117.

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        
        if(root == null)
            return ;
        
        if(root.left != null){
            if(root.right != null)
                root.left.next = root.right;
            else
                root.left.next = nextLink(root);
        }
        
        if(root.right != null)
            root.right.next = nextLink(root);
            
        connect(root.right);
        connect(root.left);
    }
    
    public TreeLinkNode nextLink(TreeLinkNode root){
        
        if(root.next == null)
            return null;
        
        while(root.next != null){
            
            root = root.next;
            
            if(root.left != null)
                return root.left;
            else if(root.right != null)
                return root.right;
        }
        return null;
    }
}
