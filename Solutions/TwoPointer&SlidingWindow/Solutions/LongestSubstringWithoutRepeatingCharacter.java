class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character , Integer> map=new HashMap();
        int left=0, right=0, len=0;
        for (right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))) left=Math.max(left, map.get(s.charAt(right))+1);
            map.put(s.charAt(right), right);
            len=Math.max(len, right-left+1);
        }
        return len;
    }
}