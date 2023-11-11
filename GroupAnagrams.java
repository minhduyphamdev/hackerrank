// 19/09
// problem: https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String newStr = new String(chars);
      if (!map.containsKey(newStr)) {
        map.put(newStr, new ArrayList<>());
      }

      map.get(newStr).add(str);

    }
    return new ArrayList<>(map.values());

  }

  public static void main(String[] args) {
    String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
    GroupAnagrams groupAnagrams = new GroupAnagrams();
    List<List<String>> list = groupAnagrams.groupAnagrams(strs);
    // Print the contents of the list
    for (List<String> innerList : list) {
      for (String str : innerList) {
        System.out.print(str + " ");
      }
      System.out.println();
    }
  }
}
