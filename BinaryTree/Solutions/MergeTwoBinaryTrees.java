/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // Method 1
 class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        int data=root1==null?0:root1.val;
        data+=root2==null?0:root2.val;
        TreeNode root=new TreeNode(data);
        root.left=mergeTrees(root1.left, root2.left);
        root.right=mergeTrees(root1.right, root2.right);
        return root;
    }
}

 // Method 2
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.val+=root2.val;
        root1.left=mergeTrees(root1.left, root2.left);
        root1.right=mergeTrees(root1.right, root2.right);
        return root1;
    }
}