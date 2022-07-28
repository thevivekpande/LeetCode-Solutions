// Recursion 
class Solution {
    public boolean helper(int ind, int n, int[] nums, int sum){
        if(sum==0) return true;
        if(ind==n || sum<0) return false;
        return helper(ind+1, n, nums, sum) | helper(ind+1, n, nums, sum-nums[ind]);
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;
        sum>>=1;
        return helper(0, nums.length-1, nums, sum+1);
    }
}

// Tabulation (Top Down)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;
        sum>>=1;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int i:nums){
            for(int j=sum;j>0;j--){
                if(j>=i){
                    dp[j]=dp[j] | dp[j-i];
                }
            }
        }
        return dp[sum];
    }
}