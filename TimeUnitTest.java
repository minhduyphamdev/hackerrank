import java.util.concurrent.TimeUnit;

public class TimeUnitTest {
  public static void main(String[] args) {
    long minutes = TimeUnit.MINUTES.convert(60, TimeUnit.SECONDS);
    System.out.println(minutes);
  }
  
}
