// Boundary DFS
class Solution {
    public void solve(char[][] board) {
        int m=board.length, n=board[0].length;
        if(m==1 || n==1 ) return;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                dfs(board, i, 0, m, n);
            if(board[i][n-1]=='O')
                dfs(board, i, n-1, m, n);
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O')
                dfs(board, 0, i, m, n);
            if(board[m-1][i]=='O')
                dfs(board, m-1, i, m, n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='@')
                    board[i][j]='O';
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!='O') return;
       
            board[i][j]='@';
            dfs(board, i+1, j, m, n);
            dfs(board, i-1, j, m, n);
            dfs(board, i, j+1, m, n);
            dfs(board, i, j-1, m, n);
        
    }
}