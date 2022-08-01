class Solution {
    public void dfs(char grid[][], int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return;
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            dfs(grid, i+1, j, m, n);
            dfs(grid, i-1, j, m, n);
            dfs(grid, i, j+1, m, n);
            dfs(grid, i, j-1, m, n);
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length, n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
}