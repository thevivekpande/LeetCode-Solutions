class Solution {
    public int calculate(String s) {
        int n=s.length();
        if(s.length()==0) return 0;
        int num=0;
        Stack<Integer> stack=new Stack();
        char sign='+';
        int i=0;
        while(i<n){
            char cur=s.charAt(i);
            if(Character.isDigit(cur)){
                num=num*10+(cur-'0');
            }
            if((!Character.isDigit(cur) && cur!=' ') || i==n-1){
                if(sign=='-')
                    stack.push(-num);
                else if(sign=='+')
                    stack.push(num);
                else if(sign=='*')
                    stack.push(num*stack.pop());
                else if(sign=='/')
                    stack.push(stack.pop()/num);
                num=0;
                sign=cur;
            }
            i++;
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;    
    }
}