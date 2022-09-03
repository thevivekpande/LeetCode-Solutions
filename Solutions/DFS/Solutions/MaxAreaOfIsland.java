class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] isVis=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                res=Math.max(res, dfs(grid, i, j, isVis));
        return res;
    }
    
    public int dfs(int[][] grid, int m, int n, boolean[][] isVis){
        if(m<0 || m>=grid.length || n<0 || n>=grid[0].length || isVis[m][n] || grid[m][n]==0) return 0;
        isVis[m][n]=true;
        return 1 + dfs(grid, m+1, n, isVis)
            + dfs(grid, m, n+1, isVis)
            + dfs(grid, m-1, n, isVis)
            + dfs(grid, m, n-1, isVis);
    }
}