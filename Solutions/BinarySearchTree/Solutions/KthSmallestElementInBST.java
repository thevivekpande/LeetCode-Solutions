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

// Using Recursive inorder traversal
class Solution {
    private void helper(TreeNode root, ArrayList<Integer> list){
        if(root==null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList();
        helper(root, list);
        return list.get(k-1);
    }
}

// Using Iterative inorder traversal
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k==0) return root.val;
            root=root.right;
        }
    }
}

// Using Morris Inorder Traversal
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left==null){
                k--;
                if(k==0) return temp.val;
                temp=temp.right;
            }else{
                TreeNode prev=temp.left;
                while(prev.right!=null && prev.right!=temp)
                    prev=prev.right;
                
                if(prev.right==null){
                    prev.right=temp;
                    temp=temp.left;
                }else{
                    prev.right=null;
                    k--;
                    if(k==0) return temp.val;
                    temp=temp.right;
                }
            }
        }
        return -1;
    }
}