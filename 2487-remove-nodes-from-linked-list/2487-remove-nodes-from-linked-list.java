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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
          while(!s.isEmpty() && curr.val>s.peek().val){
                   s.pop();
          }
          s.push(curr);
          curr=curr.next;
        }
        ListNode res=null,prev=null;
        while(!s.isEmpty()){
            ListNode node = new ListNode(s.pop().val,prev);
            node.next = prev;
            prev=node;
            res = node;
        }
        return res;
       
    }
}