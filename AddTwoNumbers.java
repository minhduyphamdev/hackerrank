
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.next = next;
    this.val = val;
  }
}

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode resultTemp = null;
    int carry = 0;
    int sum = 0;

    while (l1 != null || l2 != null) {
      sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      sum += carry;
      carry = sum / 10;
      sum = sum % 10;
      if (result == null) {
        result = new ListNode(sum);
        resultTemp = result;
      } else {
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
    ListNode node1 = new ListNode(2);
    node1.next = new ListNode(4);
    node1.next.next = new ListNode(3);

    ListNode node2 = new ListNode(5);
    node2.next = new ListNode(6);
    node2.next.next = new ListNode(4);

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode result = addTwoNumbers.addTwoNumbers(node1, node2);
    while (result != null) {
      System.out.println(result.val + " ");
      result = result.next;
    }

  }
}