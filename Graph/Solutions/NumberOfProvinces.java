class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVis){
        isVis[node]=true;
        for(int it:adj.get(node))
            if(!isVis[it])
                dfs(it, adj, isVis);
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] isVis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!isVis[i]){
                dfs(i, adj, isVis);
            count++;
            }
        }
        return count;
    }
        
}

// Method 2 (Better)
class Solution {
    public void dfs(int i, int[][] isConnected, boolean[] isVis){
        for(int j=0;j<isConnected.length;j++)
            if(!isVis[j] && isConnected[i][j]==1){
                isVis[j]=true;
                dfs(j, isConnected, isVis);
            }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] isVis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!isVis[i]){
                dfs(i, isConnected, isVis);
            count++;
            }
        }
        return count;
    }
        
}