// Question Link : https://leetcode.com/problems/sort-list/
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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode newHead = new ListNode(list.get(0));
        ListNode temp = newHead;
        int size = list.size()-1;
        int i = 1;
        while(size-- > 0){
            temp.next = new ListNode(list.get(i++));
            temp = temp.next;
        }
        return newHead;    
    }
}