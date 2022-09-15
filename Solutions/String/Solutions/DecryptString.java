class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res=new StringBuilder();
        int i=0, n=s.length();
        while(i<n){
            if(i+2<n && s.charAt(i+2)=='#'){
                res.append((char)('a'+ Integer.valueOf(s.substring(i, i+2)) - 1));
                i+=3;
            }
            else {
                res.append((char)('a' + Integer.valueOf(s.substring(i, i+1)) - 1));
                i++;
            }
        }
        return res.toString();
    }
}