/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 1.*** PROBLEM 515. Find Largest Value in Each Tree Row ***
 
 public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. *** PROBLEM 513. Find Bottom Left Tree Value
EXPLANATION: Given a binary tree, find the leftmost value in the last row of the tree.

public class Solution {
    
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. *** 230. Kth Smallest Element in a BST ***
EXPLANATION: Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

public class Solution {
    int count = 0;
    boolean firstLeaf = false;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
            
        if(root.left == null && firstLeaf == false)
            firstLeaf = true;
                
        int a = kthSmallest(root.left, k);
        
        if(firstLeaf == true)
            count++;
        if(count == k)
            return root.val;
        
        if (a==-1)
            a = kthSmallest(root.right, k);
        
        return a;
    
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. *** 145. Binary Tree Postorder Traversal ***

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. *** 144. Binary Tree Preorder Traversal ***

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. *** 94. Binary Tree Inorder Traversal ***

public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7. *** 129. Sum Root to Leaf Numbers ***
EXPLANATION: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
             An example is the root-to-leaf path 1->2->3 which represents the number 123.
			 
public class Solution {
    
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
8. *** 116. Populating Next Right Pointers in Each Node ***
EXPLANATION: Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
             Initially, all next pointers are set to NULL.
			 
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if(root == null || root.left == null)
            return ;
            
        root.left.next = root.right;
        
        if(root.next != null)
            root.right.next = root.next.left;
        
        connect(root.left);
        connect(root.right);
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9. *** 117. Populating Next Right Pointers in Each Node II ***
EXPLANATION: Follow up for problem "Populating Next Right Pointers in Each Node".
             What if the given tree could be any binary tree? Would your previous solution still work?
			 
public class Solution {
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10. *** 112. Path Sum ***
EXPLANATION: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

public class Solution {
    
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11. *** 110. Balanced Binary Tree ***

public class Solution {
    public boolean isBalanced(TreeNode root) {
        
         return height(root, 1) != -1;
        
    }
    public int height(TreeNode root, int height) {

        if (root==null)
            return height;
        
        int left = height(root.left, height+1);
        int right = height(root.right, height+1);

        return Math.abs(left-right) > 1 ? -1 : Math.max(left,right);
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
12. *** 105. Construct Binary Tree from Preorder and Inorder Traversal

public class Solution {
    
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
13. *** 104. Maximum Depth of Binary Tree ***

public class Solution {
    int maxDepth = 0;
    int depth = 1;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        max(root);
        return maxDepth;
    }
    public void max(TreeNode root){
        if(root.left != null){
            depth++;
            if(depth > maxDepth)
                maxDepth = depth;
            max(root.left);
        }
        if(root.right != null){
            depth++;
            if(depth > maxDepth)
                maxDepth = depth;
            max(root.right);
        }
        depth--;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
14. *** 101. Symmetric Tree ***

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode l, TreeNode r){
        if(l == r)
            return true;
        if(l == null || r == null)
            return false;
        return (l.val == r.val) && isSym(l.left,r.right) && isSym(l.right,r.left);
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15. *** 100. Same Tree ***

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q)
            return true;
        if(p == null || q == null)
            return false;
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}