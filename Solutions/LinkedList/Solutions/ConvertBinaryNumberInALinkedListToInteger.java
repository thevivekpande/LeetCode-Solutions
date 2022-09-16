// Method1
class Solution {
    private ListNode reverse(ListNode head){
        ListNode prev=null, curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) {
        head=reverse(head);
        int res=0;
        int c=0;
        while(head!=null){
            res+=(head.val<<(c++));
            head=head.next;
        }
        return res;
    }
}

// Method 2
class Solution {
    public int getDecimalValue(ListNode head) {
        int res=0;
        while(head!=null){
            res=(res<<1)|head.val;
            head=head.next;
        }
        return res;
    }
}