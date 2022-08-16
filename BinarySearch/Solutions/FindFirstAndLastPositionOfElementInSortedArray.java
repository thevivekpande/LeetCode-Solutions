class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        if(n==0 || nums[0]>target || nums[n-1]<target) return new int[]{-1,-1};
        int[] res=new int[2];
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]>=target)
                r=mid-1;
            else 
                l=mid+1;
        }
        
        if(nums[l]!=target) return new int[]{-1, -1};
        
        res[0]=l;
        r=n-1;
        
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target)
                l=mid+1;
            else 
                r=mid-1;
        }
        res[1]=r;
        
        return res;
    }
}