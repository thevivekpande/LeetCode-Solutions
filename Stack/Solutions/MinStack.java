class Pair{
    int val;
    int min;
    Pair(int _val, int _min){
        val=_val;
        min=_min;
    }
}
class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack=new Stack();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new Pair(val, val));
        else
            stack.push(new Pair(val, Math.min(val, stack.peek().min)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */