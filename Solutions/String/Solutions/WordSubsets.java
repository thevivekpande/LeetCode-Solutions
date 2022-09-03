class Solution {
    private boolean isSubset(String s, int[] hash2, int total){
        int count=0;
        int[] hash1=new int[26];
        for(char ch:s.toCharArray()){
            hash1[ch-'a']++;
            if(hash1[ch-'a']==hash2[ch-'a'] && hash2[ch-'a']>0) count++;
        }
        return total==count;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList();
        int[] hash2=new int[26];
        for(String s:words2){
            int[] temp=new int[26];
            for(char ch: s.toCharArray()){
                temp[ch-'a']++;
                hash2[ch-'a']=Math.max(temp[ch-'a'], hash2[ch-'a']);
            }
        }
        int total=0;
        for(int i:hash2)
            total+=i>0?1:0;
        for(String s:words1)
            if(isSubset(s, hash2, total))
                res.add(s);
        return res;
    }
}