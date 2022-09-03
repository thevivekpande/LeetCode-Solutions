class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList();
        if(s==null || p==null || s.length()==0 || p.length()==0)
            return res;
        int[] hash=new int[128];
        for(char ch : p.toCharArray())
            hash[ch]++;
        int left=0, right=0, count=p.length();
        while(right<s.length()){
            if(hash[s.charAt(right++)]-- >= 1) count--;
            if(count==0) res.add(left);
            if(right-left==p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return res;
    }
}