class Node {
  Object value;
  Node next;  

  public Node() {
    this.value = null;
    this.next = null;
  }

  public Node(Object data) {
    this.value = data;
    this.next = null;
  }
}

public class LinkedListScratch {
  private Node head;
  private int size;

  public LinkedListScratch() {
    head = null;
    size  = 0;
  }

  public void add(Object data) {
    if(head == null) {
      head = new Node(data);
    }
    else {
      Node node = head;
      while(node.next!=null) {
        node = node.next;
      }
      Node newNode = new Node(data);
      node.next = newNode;
    }
    size ++;
  }

  public Object get(int index) {
    if (index<0 || index>=size) {
      throw new IndexOutOfBoundsException("index " + index +" is out of range.");
    }

    Node current = head;
    for(int i=0;i<index;i++) {
      current= current.next;
    }
    return current.value;
  }

  public void printList() {
    Node current = head;
    System.out.print("List: ");
    while(current!=null) {
      System.out.print(String.valueOf(current.value)+ " ");
      current=current.next;
    }
    System.out.println();
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    LinkedListScratch linkedList = new LinkedListScratch();

    linkedList.add(2);
    linkedList.add(3);

    linkedList.printList();

  }
}
