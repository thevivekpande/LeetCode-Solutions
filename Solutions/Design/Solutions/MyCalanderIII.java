class MyCalendarThree {
    TreeMap<Integer, Integer> myCalander;

    public MyCalendarThree() {
        myCalander=new TreeMap();
    }
    
    public int book(int start, int end) {
        int res=0, cur=0;
        myCalander.put(start, myCalander.getOrDefault(start, 0)+1);
        myCalander.put(end, myCalander.getOrDefault(end, 0)-1);
        for(int v : myCalander.values())
            res=Math.max(res, cur+=v);
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */