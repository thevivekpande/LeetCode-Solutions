class Solution {
    private void helper(int ind, int[] nums, int target, List<Integer> ds, List<List<Integer>> res){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList(ds));
        }
        else{
            for(int i=ind;i<nums.length;i++){
                if(ind!=i && nums[i]==nums[i-1]) continue;
                ds.add(nums[i]);
                helper(i+1, nums, target-nums[i], ds, res);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList(), res);
        return res;
    }
}