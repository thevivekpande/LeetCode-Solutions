// Method 1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character, Character> map1=new HashMap();
        Map<Character, Character> map2=new HashMap();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(!map1.containsKey(c1)) map1.put(c1, c2);
            if(!map2.containsKey(c2)) map2.put(c2, c1);
            if(map1.get(c1)!=c2 || map2.get(c2)!=c1) return false;
        }
        return true;
    }
}

// Method 2
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map map1=new HashMap();
        Map map2=new HashMap();
        for(int i=0;i<s.length();i++)
            if(!Objects.equals(map1.put(s.charAt(i), i),map2.put(t.charAt(i), i)))
                return false;
        return true;
    }
}