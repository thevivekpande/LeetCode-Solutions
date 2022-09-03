// Recursion
class Solution {
    private int helper(int ind, int[] nums){
        if(ind>=nums.length-1) return 0;
        int min=(int)1e6;
        for(int ii=1;ii<=nums[ind];ii++)
            min=Math.min(min, 1+helper(ind+ii, nums));
        return min;
    }
    public int jump(int[] nums) {
        return helper(0, nums);
    }
}

// Memoization
class Solution {
    private int helper(int ind, int[] nums, int[] dp){
        if(ind>=nums.length-1) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int min=(int)1e6;
        for(int ii=1;ii<=nums[ind];ii++)
            min=Math.min(min, 1+helper(ind+ii, nums, dp));
        return dp[ind]=min;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }
}