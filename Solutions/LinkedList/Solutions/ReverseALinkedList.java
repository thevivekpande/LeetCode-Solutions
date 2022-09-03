// Iterative Approach
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null, curr=head;
        
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        return prev;
    }
}

// Recursive Approach
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}