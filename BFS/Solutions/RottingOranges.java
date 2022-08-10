class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList();
        int totalOranges=0;
        int m=grid.length, n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i, j});
                totalOranges+=(grid[i][j]==0)?0:1;
            }
        }
        
        int oranges=0;
        int[][] dir=new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int res=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            oranges+=size;
            for(int i=0;i<size;i++){
                
                int[] cur=q.poll();
                for(int j=0;j<4;j++){
                    int x=cur[0]+dir[j][0];
                    int y=cur[1]+dir[j][1];
                    
                    if(x<0 || y<0 || x>=m || y>=n) continue;
                    
                    if(grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            res+=q.size()==0?0:1;
        }
        
        return oranges==totalOranges?res:-1;
    }
}