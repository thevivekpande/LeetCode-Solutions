class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n=strs.length;
        int len1=strs[0].length();
        int len2=strs[n-1].length();
        int i=0;
        while(i<len1 && i<len2 && strs[0].charAt(i)==strs[n-1].charAt(i)) i++;
        return strs[0].substring(0, i);
    }
}