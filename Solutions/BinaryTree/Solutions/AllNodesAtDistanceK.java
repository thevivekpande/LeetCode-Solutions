/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parents;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents=new HashMap<>();
        dfs(root, null);
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        
        Set<TreeNode> seen=new HashSet<>();
        seen.add(target);
        
        int dist=0;
        while(!q.isEmpty()){
            if(dist==k) break;
            dist++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !seen.contains(node.left)){
                    seen.add(node.left);
                    q.offer(node.left);
                }
                if(node.right!=null && !seen.contains(node.right)){
                    seen.add(node.right);
                    q.offer(node.right);
                }
                TreeNode par=parents.get(node);
                if(par!=null && !seen.contains(par)){
                    seen.add(par);
                    q.offer(par);
                }
            }
        }
        
        
        List<Integer> res=new ArrayList();
        for(TreeNode n : q)
            res.add(n.val);
        return res;
    }
    private void dfs(TreeNode root, TreeNode parent){
        if(root==null) return;
        parents.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}