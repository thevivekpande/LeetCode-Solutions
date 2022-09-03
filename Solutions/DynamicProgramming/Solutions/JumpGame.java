// Recursion (TLE)
class Solution {
    private boolean helper(int i, int[] nums){
        if(i>=nums.length-1) return true;
        if(nums[i]==0) return false;
        int jumps=nums[i];
        for(int ii=1;ii<=jumps;ii++)
            if(helper(ii+i, nums))
                return true;
        return false;
    }
    public boolean canJump(int[] nums) {
        return helper(0, nums);
    }
}

// Memoization
class Solution {
    private boolean helper(int i, int[] nums, int[] dp){
        if(i >= nums.length-1)
            return true;
        if(nums[i]==0) {
            dp[i]=0;
            return false;
        }
        
        if(dp[i]!=-1) return dp[i]==1;
        
        int jumps=nums[i];
        for(int ii=1;ii<=jumps;ii++)
            if(helper(i+ii, nums, dp)){
                dp[i+ii]=1;
                return true;
            }
        dp[i]=0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }
}