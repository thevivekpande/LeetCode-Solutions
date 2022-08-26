class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE, sum=0, left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                res=Math.min(right-left+1, res);
                sum-=nums[left++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}