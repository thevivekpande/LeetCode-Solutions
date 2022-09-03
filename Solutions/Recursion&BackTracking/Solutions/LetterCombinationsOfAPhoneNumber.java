// Recursive
class Solution {
    private void helper(int ind, String digits, String[] values, StringBuilder ds, List<String> res){
        if(ds.length()==digits.length())
            res.add(ds.toString());
        else{
            char[] charArr=(values[digits.charAt(ind)-'0']).toCharArray();
            for(int i=0;i<charArr.length;i++){
                ds.append(charArr[i]);
                helper(ind+1, digits, values, ds, res);
                ds.deleteCharAt(ds.length()-1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] values=new String[]{"", "", "abc","def", "ghi", "jkl","mno", "pqrs", "tuv","wxyz"};
        List<String> res=new ArrayList();
        if(digits.length()==0) return res;
        helper(0, digits, values, new StringBuilder(), res);
        return res;
    }
}

// Iterative
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] values=new String[]{"", "", "abc","def", "ghi", "jkl","mno", "pqrs", "tuv","wxyz"};
        
        List<String> res=new ArrayList();
        if(digits.length()==0) return res;
        res.add("");
        
        for(int i=0;i<digits.length();i++){
            List<String> tmp=new ArrayList();
            for(char ch : values[digits.charAt(i)-'0'].toCharArray()){
                for(String s : res){
                    tmp.add(s+ch);
                }
            }
            res=tmp;
        }
        
        return res;
    }
}