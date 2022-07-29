class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int start=i+1, last=nums.length-1;
            while(start<last){
                int sum=nums[i]+nums[start]+nums[last];
                if(sum>target)
                    last--;
                else 
                    start++;
                if(Math.abs(target-sum)<Math.abs(target-result))
                    result=sum;
            }
        }
        return result;
    }
}