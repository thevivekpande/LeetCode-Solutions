class LList{
    String val;
    LList prev;
    LList next;
    LList(String val){
        this.val=val;
        next=null;
        prev=null;
    }
}
class BrowserHistory {
    LList head;
    public BrowserHistory(String homepage) {
        head=new LList(homepage);
    }
    
    public void visit(String url) {
        LList node=new LList(url);
        head.next=node;
        node.prev=head;
        head=node;
    }
    
    public String back(int steps) {
        while(head.prev!=null && steps-->0 )
            head=head.prev;
        return head.val;
    }
    
    public String forward(int steps) {
         while(head.next!=null && steps-->0)
            head=head.next;
        return head.val;
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */