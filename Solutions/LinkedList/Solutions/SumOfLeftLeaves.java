class Solution {
    public int helper(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        if(root.left==null && root.right==null && isLeft)
            return root.val;
        return helper(root.left, true)+helper(root.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
}