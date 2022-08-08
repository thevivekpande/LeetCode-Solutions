class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[count++]=nums[i];
            }
        }
        for(int j=count;j<n;j++)
            nums[j]=0;
    }
}