/* Leetcode Problem 129.

public class SumRootToLeafNumbers {
    
    int i=0;
    
    public int sumNumbers(TreeNode root) {
        leaf(root, 0);
        return i;
    }
    
    public void leaf(TreeNode root, int prev){
        if(root == null)
            return ;
            
        int newVal = prev * 10 + root.val;
        
        if(root.left == root.right)
            i += newVal;
            
        leaf(root.left, newVal);
        leaf(root.right, newVal);
    }
}
