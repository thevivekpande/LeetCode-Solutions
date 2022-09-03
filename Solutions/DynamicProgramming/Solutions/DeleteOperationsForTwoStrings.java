// Method 1
// using LCS problem
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return m+n-(2*dp[m][n]);
    }
}

// Method 2
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}
