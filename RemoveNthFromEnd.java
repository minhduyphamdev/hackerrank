package hackerrank;
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=0;i<=n;i++) {
            first= first.next;
        }
        while(first!=null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3,a);
        ListNode c = new ListNode(4,b);
        ListNode d = new ListNode(5,c);
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = removeNthFromEnd.removeNthFromEnd(d,2);
        while(head!=null) {
            System.out.print(head.val+ " ");
            head= head.next;
        }

    }
}
