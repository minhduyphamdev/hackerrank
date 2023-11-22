import java.util.*;

public class FailFastDemo {
  public static void main(String[] args) {
    Map<String,String> empName = new HashMap<>();
    empName.put("Sam Hanks", "New york");   
    empName.put("Will Smith", "LA");   
    empName.put("Scarlett", "Chicago");   
    Iterator iterator = empName.keySet().iterator();
    while(iterator.hasNext()) {
      System.out.println(empName.get(iterator.next()));

      empName.put("Test","Test");
    }
  }
}
