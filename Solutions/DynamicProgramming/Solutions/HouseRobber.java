// Recursion
class Solution {
    public int f(int i, int[] nums){
        if(i<0) return 0;
        if(i==0) return nums[0];
        int notPick=f(i-1, nums);
        int pick=nums[i]+f(i-2, nums);
        return Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        return f(n-1, nums);
    }
}

//Memoization (Top Down)
class Solution {
    public int f(int i, int[] nums, int[] dp){
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int notPick=f(i-1, nums, dp);
        int pick=nums[i]+f(i-2, nums, dp);
        return dp[i]=Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return f(n-1, nums, dp);
    }
}

// Tabulation (Bottom Up)
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<n;i++){
            dp[i+1]=Math.max(dp[i], nums[i]+dp[i-1]);
        }
        return dp[n];
    }
}

// Optimization
class Solution {
    public int rob(int[] nums) {
        int first=0;
        int second=nums[0];
        for(int i=1;i<nums.length;i++){
            int cur=Math.max(second, nums[i]+first);
            first=second;
            second=cur;
        }
        return second;
    }
}