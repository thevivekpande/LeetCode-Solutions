class Solution {
    private int res;
    private void preOrder(TreeNode root, int path){
        if(root==null) return;
        path^=1<<root.val;
        if(root.left==null && root.right==null)
            if((path&(path-1))==0) 
                res++;
        preOrder(root.left, path);
        preOrder(root.right, path);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        res=0;
        preOrder(root, 0);
        return res;
    }
}