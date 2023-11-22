import java.util.*;

public class HashSetDemo {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>(); 
  
        // Add data to HashMap 
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Grapes");
        set.add("Apple");  // Dupl
  
        // Create a iterator of type integer to iterate 
        // HashSet 
        Iterator<String> it = set.iterator(); 
  
        System.out.println( 
            "Iterate HashSet using iterator : "); 
  
        // Iterate HashSet with the help of hasNext() and 
        // next() method 
        while (it.hasNext()) { 
  
            // Print HashSet values 
            System.out.print(it.next() + " "); 
        } 
  }
}