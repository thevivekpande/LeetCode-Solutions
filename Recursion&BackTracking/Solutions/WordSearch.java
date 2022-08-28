class Solution {
    public boolean dfs(char[][] board, int i, int j, char[] word, int ind){
        if(ind==word.length) return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]!=word[ind]) return false;
        board[i][j]^=256;
        boolean res=dfs(board, i+1, j, word, ind+1) || dfs(board, i, j+1, word, ind+1) || dfs(board, i-1, j, word, ind+1) || dfs(board, i, j-1, word, ind+1);
        board[i][j]^=256;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(board, i, j, word.toCharArray(), 0))
                    return true;
            }
        }
        return false;
    }
    
}