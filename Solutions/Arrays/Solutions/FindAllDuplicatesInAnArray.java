// Using extra space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap();
        List<Integer> res=new ArrayList();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
            if(map.get(i)==2) res.add(i);
        }
        return res;
    }
}

// Without using Extra space

// invert the numbers with its neg at ind i-1
// if any number at ind i-1 is found already negative 
// that means number i has appears twice 
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList();
        for(int i=0;i<nums.length;i++){
            int ind=Math.abs(nums[i])-1;
            if(nums[ind]<0)
                res.add(Math.abs(ind+1));
            nums[ind]=-nums[ind];
        }
        return res;
    }
}