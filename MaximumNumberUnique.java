import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumNumberUnique {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = in.nextInt();
    int m = in.nextInt();
    long max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      deque.add(num);
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
      if (deque.size() == m + 1) {
        int firstEle = deque.poll();
        if (map.get(firstEle) > 1) {
          map.put(firstEle, map.get(firstEle) - 1);
        } else {
          map.remove(firstEle);
        }

      }

      if (deque.size() == m) {
        max = Math.max(max, map.size());
      }
    }

    System.out.println(max);
  }
}
