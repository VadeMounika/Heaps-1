 //brute force implementation 
 //Nk^2 time complexity
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        for(ListNode list : lists)
        {
            temp = helper(temp, list);

        }
        return temp.next;  
    }

    private ListNode helper(ListNode head1, ListNode head2)
    {
        ListNode temp = new ListNode(-1);
        ListNode  dummy = temp;

        while(head1 != null && head2 != null)
        {
            if(head1.val > head2.val)
            {
                dummy.next = head2;
                head2 = head2.next;

            }
            else{
                dummy.next = head1;
                head1 = head1.next;
            }
            dummy = dummy.next;

        }
        if(head1 != null){
            dummy.next = head1;
        }
        if(head2 != null){
            dummy.next = head2;
        }

        return temp.next;

    }
}

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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

       // MinHeap
        PriorityQueue<ListNode> pq =
         new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list : lists)
        {
            if(list != null){
            pq.add(list);
            }
        }

        while (!pq.isEmpty()) {

            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
            
        }

        return dummy.next;
    }
}