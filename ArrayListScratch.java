import java.util.Arrays;

public class ArrayListScratch<T> {
  private Object[] elements;
  private static final int DEFAULT_SIZE = 10;
  private int size = 0;

  public ArrayListScratch() {
    elements  = new Object[DEFAULT_SIZE];
  }

  public void add(T e) {
    if(size == elements.length) {
      updateSize();
    }

    elements[size++] = e;
  }

  public void updateSize() {
    int newLength = elements.length * 2;
    elements= Arrays.copyOf(elements, newLength);
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index " + index +" is out of range.");
    }

    return elements[index];
  }

  public void delete(int index) {
    if(index < 0 || index >= size ) {
      throw new IndexOutOfBoundsException("index " + index +" is out of range.");
    }

    int moveSize = size - index - 1;
    System.arraycopy(elements, index+1, elements, index, moveSize);

    elements[--size] = null;
  }

  public void print() {
    System.out.print("Array: ");
    for(int i=0;i<size; i++) {
      System.out.print(elements[i]+ " ");
    }
  }
  
  public void printArray() {
    System.out.println(Arrays.toString(Arrays.copyOf(elements,size)));
}

  public static void main(String[] args) {
    ArrayListScratch array = new ArrayListScratch<Integer>();
    array.add(1);
    array.add(2);
    array.print();

  }
}
 