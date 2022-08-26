// Binary Search and Logarithms
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        double lk=Math.log(k);
        int n=nums.length;
        int res=0;
        double[] prefix=new double[n+1];
        for(int i=0;i<n;i++)
            prefix[i+1]=prefix[i]+Math.log(nums[i]);
        for(int i=0;i<n;i++){
            int lo=i+1, hi=n+1;
            while(lo<hi){
                int mid=lo+((hi-lo)>>1);
                if(prefix[mid]<prefix[i]+ lk- 1e-9) lo=mid+1;
                else hi=mid;
            }
            res+=lo-i-1;
        }
        return res;
    }
}


// Sliding Window
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int res=0, prod=1;
        int left=0;
        for(int right=0;right<nums.length;right++){
            prod*=nums[right];
            while(prod>=k){
                prod/=nums[left++];
            }
            res+=right-left+1;
        }
        return res;
    }
}