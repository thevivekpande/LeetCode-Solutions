// Recursion
class Solution {
    public int numDecodings(String s) {
        return helper(0, s);
    }
    private int helper(int ind, String s){
        int n=s.length();
        if(n==ind) return 1;
        if(s.charAt(ind)=='0') return 0;
        int res=helper(ind+1, s);
        if(ind<n-1 && (s.charAt(ind)=='1' || (s.charAt(ind)=='2' && s.charAt(ind+1)<'7'))) res+=helper(ind+2, s);
        return res;
    }
}

// Memoization
class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
    private int helper(int ind, String s, int[] dp){
        int n=s.length();
        if(n==ind) return 1;
        if(dp[ind]!=-1) return dp[ind];
        if(s.charAt(ind)=='0') return 0;
        int res=helper(ind+1, s, dp);
        if(ind<n-1 && (s.charAt(ind)=='1' || (s.charAt(ind)=='2' && s.charAt(ind+1)<'7'))) res+=helper(ind+2, s, dp);
        return dp[ind]=res;
    }
}
