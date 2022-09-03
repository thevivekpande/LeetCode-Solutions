class Solution {
    private void helper(int ind, int[] nums, List<Integer> ds, List<List<Integer>> res){
        res.add(new ArrayList(ds));
        for(int i=ind;i<nums.length;i++){
            ds.add(nums[i]);
            helper(i+1, nums, ds, res);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        helper(0, nums, new ArrayList(), res);
        return res;
    }
}