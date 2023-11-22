import java.util.*;

public class TreeMapDemo {
  public static void main(String[] args) {
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(3, "Three");
    treeMap.put(1, "One");
    treeMap.put(2, "Two");

    for(Map.Entry<Integer,String> entry : treeMap.entrySet()) {
      System.out.println(entry.getKey()+" "+entry.getValue());
    }
  }
}
