import java.util.HashSet;
import java.util.Set;

public class LongestDistinctSubString {
  // use O(n^3) method loop through string to check if string is distintct
  // public static boolean isDistinct(String str, int start, int end) {
  // boolean[] isVisited = new boolean[256];
  // for (int i = start; i <= end; i++) {
  // if (isVisited[str.charAt(i)] == true) {
  // return false;
  // }
  // isVisited[str.charAt(i)] = true;
  // }
  // return true;
  // }

  public static boolean isDistinct(String str, int start, int end) {
    Set<Character> set = new HashSet<Character>();
    for (int i = start; i <= end; i++) {
      set.add(str.charAt(i));
    }

    return set.size() == (end - start + 1);

  }

  public static int findMaxDistinctSubString(String str) {
    int len = str.length();
    int max = 1;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (isDistinct(str, i, j)) {
          max = Math.max(max, j - i + 1);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String str = "pwwkew";
    System.out.println(findMaxDistinctSubString(str));
  }
}
