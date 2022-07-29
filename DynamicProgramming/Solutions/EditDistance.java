// Recursion
class Solution {
    private int helper(String word1, String word2, int m, int n){
        if(m<0) return n+1;
        if(n<0) return m+1;
        if(word1.charAt(m)==word2.charAt(n)) return helper(word1, word2, m-1, n-1);
        return 1+Math.min(helper(word1, word2, m-1, n-1), Math.min(helper(word1, word2, m, n-1), helper(word1, word2, m-1, n)));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        return helper(word1, word2, m-1, n-1);
    }
}

// Memoization (Top Down)
class Solution {
    private int helper(String word1, String word2, int m, int n, int[][] dp){
        if(m<0) return n+1;
        if(n<0) return m+1;
        if(dp[m][n]!=-1) return dp[m][n];
        if(word1.charAt(m)==word2.charAt(n)) return dp[m][n]=helper(word1, word2, m-1, n-1, dp);
        return dp[m][n]=1+Math.min(helper(word1, word2, m-1, n-1, dp), Math.min(helper(word1, word2, m, n-1, dp), helper(word1, word2, m-1, n, dp)));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(word1, word2, m-1, n-1, dp);
    }
}

// Tabulation (Bottom Up)
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++) dp[i][0]=i;
        for(int i=1;i<=n;i++) dp[0][i]=i;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
}