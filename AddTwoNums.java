class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 

public class AddTwoNums {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  ListNode result = null;
  ListNode resultTemp = null;
  int sum = 0 ;
  int carry = 0;
  while(l1!=null || l2!=null) {
    sum = 0;
    if(l1!=null) {
      sum += l1.val;
      l1=l1.next;
    }
    if(l2!=null) {
      sum += l2.val;
      l2=l2.next;
    }

    sum += carry;
    carry = sum / 10;
    sum = sum % 10;

    if(result == null) {
      resultTemp = new ListNode(sum);
      result = resultTemp;
    }
    else {
      resultTemp.next = new ListNode(sum);
      resultTemp = resultTemp.next;
    }

  }

  if (carry > 0) {
    resultTemp.next = new ListNode(carry);
  }

  return result;
}

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    
    AddTwoNums addTwoNums = new AddTwoNums();
    addTwoNums.addTwoNumbers(l1,l2);

  }
}
