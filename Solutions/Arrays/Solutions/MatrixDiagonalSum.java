
class Solution {
    public int diagonalSum(int[][] mat) {
        int res=0;
        int m=mat.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j)
                    res+=mat[i][j];
                else if(i+j==m-1)
                    res+=mat[i][j];
            }
        }
        return res;
    }
}