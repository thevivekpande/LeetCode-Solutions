// using stack
class Solution {
    public String helper(String str){
        Stack<Character> stack=new Stack();
        for(char ch : str.toCharArray()){
            if(ch=='#'){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }
}


// using twoPointer
class Solution {
    public boolean backspaceCompare(String s, String t) { 
        int i=s.length()-1, j=t.length()-1;
        int skipS=0, skipT=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#') { skipS++; i--;}
                else if(skipS>0) {skipS--; i--;}
                else break;
            }
            
            while(j>=0){
                if(t.charAt(j)=='#') {skipT++; j--;}
                else if(skipT>0) {skipT--; j--;}
                else break;
            }
            
            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
                return false;
            
            if((i>=0) != (j>=0))
                return false;
            
            i--; j--;
        }
        return true;
    }
}