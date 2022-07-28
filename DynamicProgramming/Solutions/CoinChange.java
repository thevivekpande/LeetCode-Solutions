// Recursion 
class Solution {
    int mod=(int)1e9;
    public int helper(int ind, int[] coins, int amount){
        if(ind==coins.length) return mod;
        if(ind==(coins.length-1)){
            if(amount%coins[ind]==0)
                return amount/coins[ind];
            return mod;
        }
        int pick=mod, notPick=mod;
        notPick=helper(ind+1, coins, amount);
        if(coins[ind]<=amount) pick=1+helper(ind, coins, amount-coins[ind]);
        return  Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int res=helper(0, coins, amount);
        return res==mod?-1:res;
    }
}

// Memoization (Top Down)
class Solution {
    int mod=(int)1e9;
    public int helper(int ind, int[] coins, int amount, int[][] dp){
        if(ind==coins.length) return mod;
        if(ind==(coins.length-1)){
            if(amount%coins[ind]==0)
                return amount/coins[ind];
            return mod;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int pick=mod, notPick=mod;
        notPick=helper(ind+1, coins, amount, dp);
        if(coins[ind]<=amount) pick=1+helper(ind, coins, amount-coins[ind], dp);
        return dp[ind][amount] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        int res=helper(0, coins, amount, dp);
        return res==mod?-1:res;
    }
}

// Tabulation (Bottom Up)
class Solution {
    int mod=(int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        
        for(int i=0;i<=amount;i++)
            if(i%coins[n-1]==0) dp[n-1][i]=i/coins[n-1];
            else dp[n-1][i]=mod;
        
        for(int i=n-2;i>=0;i--){
            for(int a=0;a<=amount;a++){
            int pick=mod, notPick=mod;
            notPick=dp[i+1][a];
            if(coins[i]<=a) pick=1+dp[i][a-coins[i]];
            dp[i][a] = Math.min(pick, notPick);
            }
        }
        
        int res=dp[0][amount];
        return res==mod?-1:res;
    }
}