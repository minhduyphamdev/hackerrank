import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
// problem: https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
// 19/09

public class MergeInterval {

  public static int[][] merge(int[][] intervals) {
    Stack<int[]> stack = new Stack<>();
    int len = intervals.length;
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    stack.push(intervals[0]);

    for (int i = 1; i < len; i++) {
      int[] top = stack.peek();

      if (top[1] < intervals[i][0]) {
        stack.push(intervals[i]);
      } else if (top[1] < intervals[i][1]) {
        top[1] = intervals[i][1];
        stack.pop();
        stack.push(top);
      }
    }
    int size = stack.size();
    int[][] arr = new int[size][2];

    for (int i = size - 1; i >= 0; i--) {
      arr[i] = stack.pop();
    }

    return arr;

  }

  public static void main(String[] args) {
    int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    int[][] results = MergeInterval.merge(intervals);
    for (int[] rows : results) {
      for (int value : rows) {
        System.out.print(value + " ");
      }
      System.out.println();
    }

  }
}
