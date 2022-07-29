// Using two HashMap
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList();
        for(String word:words)
            if(check(word, pattern))
                res.add(word);
        return res;
    }
    private boolean check(String word, String pattern){
        if(word.length()!=pattern.length());
        HashMap<Character, Character> map1=new HashMap();
        HashMap<Character, Character> map2=new HashMap();
        for(int i=0;i<word.length();i++){
            char w=word.charAt(i);
            char p=pattern.charAt(i);
            if(!map1.containsKey(w)) map1.put(w, p);
            if(!map2.containsKey(p)) map2.put(p, w);
            if(map1.get(w)!=p || map2.get(p)!=w) return false;
        }
        return true;
    }
}


// Using One hashmap and One Array
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList();
        for(String word:words)
            if(check(word, pattern))
                res.add(word);
        return res;
    }
    private boolean check(String word, String pattern){
        if(word.length()!=pattern.length());
        HashMap<Character, Character> map1=new HashMap();
        for(int i=0;i<word.length();i++){
            char w=word.charAt(i);
            char p=pattern.charAt(i);
            if(!map1.containsKey(p)) map1.put(p, w);
            if(map1.get(p)!=w) return false;
        }
        int[] hash=new int[26];
        for(char ch : map1.values()){
            if(hash[ch-'a']>0) return false;
            hash[ch-'a']++;
        }
        return true;
    }
}