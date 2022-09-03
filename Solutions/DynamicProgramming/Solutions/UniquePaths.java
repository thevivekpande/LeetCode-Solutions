// Memoization
class Solution {
    private int helper(int m, int n, int[][] dp){
        if(m==1 && n==1) return 1;
        if(m<1 || n<1) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=helper(m, n-1, dp) + helper(m-1, n, dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(m, n, dp);
    }
}


// Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1) dp[i][j]=1;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        
        return dp[m][n];
    }
}