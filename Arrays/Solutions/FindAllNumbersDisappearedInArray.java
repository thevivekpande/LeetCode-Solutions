// can be solved easily using extra space

// without using extra space
// flip the number at ind i-1 to its negative
// and traverse again, if found that number is +ve 
// then number i+1 is missing, otherwise it must be got inverted.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int ind=Math.abs(nums[i])-1;
            if(nums[ind]>0) nums[ind]=-nums[ind];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) res.add(i+1);
        }
        return res;
    }
}