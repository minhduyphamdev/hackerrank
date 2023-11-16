import java.util.GregorianCalendar;

public class TestString {
  public static void main(String[] args) {
      System.gc();
      GregorianCalendar gregorianCalendar = new GregorianCalendar();
      long start = gregorianCalendar.getTimeInMillis();
      long startMemory = Runtime.getRuntime().freeMemory();
      // StringBuffer sb = new StringBuffer();
      StringBuilder sb =new StringBuilder();
      for(int i=0; i< 100000000;i++) {
        sb.append(":").append(i);
      }
      long end = gregorianCalendar.getTimeInMillis();
      long endMemory = Runtime.getRuntime().freeMemory();
      System.out.println("Time Taken:"+(end-start));
		System.out.println("Memory used:"+(startMemory-endMemory));
  }
}
