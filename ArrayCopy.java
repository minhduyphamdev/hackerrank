public class ArrayCopy {
  public void copy(int[] a, int x, int y, int n) {
    if (x < y) {
      for (int i = n - 1; i >= 0; i--) {
        a[y + i] = a[x + i];
      }
    } else if (x > y) {
      for (int i = 0; i < n; i++) {
        a[y + i] = a[x + i];
      }
    }
  }

  public static void main(String[] args) {
    int[] sourceArr = new int[] { 2, 4, 6, 3, 5, 7, 8, 9, 10, 11, 5, 4, 5, 6 };
    ArrayCopy arrayCopy = new ArrayCopy();
    arrayCopy.copy(sourceArr, 7, 3, 6);
    for (int i : sourceArr) {
      System.out.print(i + " ");
    }

  }
}