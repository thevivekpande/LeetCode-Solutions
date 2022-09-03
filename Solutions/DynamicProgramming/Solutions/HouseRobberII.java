// Prerequisite : House Robber 
// Memoization
class Solution {
    private int helper(int i, int[] nums, int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(nums[i]+helper(i-2, nums, dp), helper(i-1, nums, dp));
    }
    private int hRobber(int[] nums, int n){
        int[] dp=new int[n];
        Arrays.fill(dp,  -1);
        return helper(n-1, nums, dp);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] num1=new int[n-1];
        int[] num2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0)
                num1[i-1]=nums[i];
            if(i!=n-1)
                num2[i]=nums[i];
        }
        return Math.max(hRobber(num1, n-1), hRobber(num2, n-1));
    }
}

// Tabulation I
class Solution {
    private int hRobber(int[] nums, int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(nums[i-1]+dp[i-2], dp[i-1]);
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] num1=new int[n-1];
        int[] num2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0)
                num1[i-1]=nums[i];
            if(i!=n-1)
                num2[i]=nums[i];
        }
        return Math.max(hRobber(num1, n-1), hRobber(num2, n-1));
    }
}

// Tabulation II
class Solution {
    private int hRobber(int[] nums, int n){
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i]+(i>1?dp[i-2]:0), dp[i-1]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] num1=new int[n-1];
        int[] num2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0)
                num1[i-1]=nums[i];
            if(i!=n-1)
                num2[i]=nums[i];
        }
        return Math.max(hRobber(num1, n-1), hRobber(num2, n-1));
    }
}

// Tabulation III (Optimised)
class Solution {
    private int hRobber(int[] nums, int n){
        int first=0;
        int second=nums[0];
        for(int i=1;i<n;i++){
            int res=Math.max(nums[i]+first, second);
            first=second;
            second=res;
        }
        return second;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] num1=new int[n-1];
        int[] num2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0)
                num1[i-1]=nums[i];
            if(i!=n-1)
                num2[i]=nums[i];
        }
        return Math.max(hRobber(num1, n-1), hRobber(num2, n-1));
    }
}