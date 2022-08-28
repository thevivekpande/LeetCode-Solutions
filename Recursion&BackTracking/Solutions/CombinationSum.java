class Solution {
    private void helper(int ind, int[] nums, int target, List<Integer> ds, List<List<Integer>> res){
        if(ind==nums.length) return;
        if(target==0){
            res.add(new ArrayList(ds));
            return;
        }
        if(target>0){
            ds.add(nums[ind]);
            helper(ind, nums, target-nums[ind], ds, res);
            ds.remove(ds.size()-1);
        }
        helper(ind+1, nums, target, ds, res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        helper(0, candidates, target, new ArrayList(), res);
        return res;
    }
}