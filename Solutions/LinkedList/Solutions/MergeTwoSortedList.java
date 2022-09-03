/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode(0);
        ListNode temp=res;
        
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=new ListNode(list1.val);
                list1=list1.next;
                temp=temp.next;
            }else{
                temp.next=new ListNode(list2.val);
                list2=list2.next;
                temp=temp.next;
            }
        }
        
        if(list1!=null)
            temp.next=list1;
        if(list2!=null)
            temp.next=list2;
        
        return res.next;
    }
}