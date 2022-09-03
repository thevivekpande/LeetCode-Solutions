// Recursion
class Solution {
    public int helper(int[] arr, int l, int r){
        if(l>=r) return 0;
        int res=Integer.MAX_VALUE;
        for(int m=l;m<r;m++){
            int temp=arr[l-1]*arr[m]*arr[r]+helper(arr, l, m)+helper(arr, m+1, r);
            res=Math.min(res, temp);
        }
        return res;
    }
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        return helper(values, 1, n-1);
    }
}


// Memoization (Top Down)
class Solution {
    public int helper(int[] arr, int l, int r, int[][] dp){
        if(l>=r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int res=Integer.MAX_VALUE;
        for(int m=l;m<r;m++){
            int temp=arr[l-1]*arr[m]*arr[r]+helper(arr, l, m, dp)+helper(arr, m+1, r, dp);
            res=Math.min(res, temp);
        }
        return dp[l][r]=res;
    }
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return helper(values, 1, n-1, dp);
    }
}