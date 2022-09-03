class Solution {
    private void helper(int n, int[] nums, List<Integer> ds, List<List<Integer>> res, boolean[] isUsed){
        if(ds.size()==n){
            if(!res.contains(ds))
                res.add(new ArrayList(ds));
            return;
        }else{
           for(int i=0;i<n;i++){
               if(isUsed[i]) continue;
               isUsed[i]=true;
               ds.add(nums[i]);
               helper(n, nums, ds, res, isUsed);
               isUsed[i]=false;
               ds.remove(ds.size()-1);
           } 
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int n=nums.length;
        boolean[] isUsed=new boolean[n];
        helper(n, nums, new ArrayList(), res, isUsed);
        return res;
    }
}