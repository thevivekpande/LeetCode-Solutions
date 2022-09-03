// Method 1
class Solution {
    public String convert(String s, int numRows) {
        HashMap<Integer, ArrayList<Character>> map=new HashMap();
        int c=0;
        boolean down=false;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(c)) map.put(c, new ArrayList());
            map.get(c).add(s.charAt(i));
            if(c==0 || c==numRows-1) down=!down;
            c+=down?1:-1;
        }
        String res="";
        for(int i=0;i<map.size();i++){
            for(char ch:map.get(i))
                res+=ch;
        }
        return res;
    }
}

// Method2
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        List<StringBuilder> rows= new ArrayList();
        for(int i=0;i<numRows;i++)
            rows.add(new StringBuilder());
        int c=0;
        boolean down=false;
        for(int i=0;i<s.length();i++){
            rows.get(c).append(s.charAt(i));
            if(c==0 || c==numRows-1) down=!down;
            c+=down?1:-1;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder str : rows)
            res.append(str);
        return res.toString();
    }
}