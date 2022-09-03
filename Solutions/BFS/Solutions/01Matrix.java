class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        if(m==0) return mat;
        
        int[][] res=new int[m][n];
        Queue<int[]> q=new LinkedList();
        
        for(int[] row:res)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dir=new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int j=0;j<4;j++){
                    int x=cur[0]+dir[j][0];
                    int y=cur[1]+dir[j][1];
                    
                    if(x<0 || x>=m || y<0 || y>=n) continue;
                    
                    if(res[x][y] > res[cur[0]][cur[1]]+1){
                        res[x][y]=res[cur[0]][cur[1]]+1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        
        return res;
    }
}