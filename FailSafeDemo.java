import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeDemo {
  public static void main(String[] args) {
  CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>(new Integer[]{1,7,9,11});
  Iterator itr = copyOnWriteArrayList.iterator();
  while(itr.hasNext()) {
    Integer i = (Integer)itr.next();   
    System.out.println(i);   
    if (i == 7)   
        copyOnWriteArrayList.add(15); // It will not be printed  
    //This means it has created a separate copy of the collection  
  }   
    Iterator itr1 = copyOnWriteArrayList.iterator();


  while(itr1.hasNext()){
    Integer i = (Integer)itr1.next();   
    System.out.println(i); 
  }
  }
}
