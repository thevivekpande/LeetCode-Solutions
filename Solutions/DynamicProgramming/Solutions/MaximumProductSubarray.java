class Solution {
    public int maxProduct(int[] nums) {
        int maxVal=nums[0], minVal=nums[0], maxProd=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxVal;
                maxVal=minVal;
                minVal=temp;
            }
            minVal=Math.min(minVal*nums[i], nums[i]);
            maxVal=Math.max(maxVal*nums[i], nums[i]);
            maxProd=Math.max(maxVal, maxProd);
        }
        return maxProd;
    }
}