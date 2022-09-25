class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0, right=height.length-1, lMax=0, rMax=0, res=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(lMax<=height[left]) lMax=height[left];
                else res+=lMax-height[left];
                left++;
            }else{
                if(rMax<=height[right]) rMax=height[right];
                else res+=rMax-height[right];
                right--;
            }
        }
        return res;
    }
}