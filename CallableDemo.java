import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    // TODO Auto-generated method stub
    int sum = 0;
    for(int i=0;i<5;i++) {
      sum+=i;
      System.err.println("Callable: "+i);
    }

    return sum;
  }

}

public class CallableDemo {
  public static void main(String[] args) {
    
    Callable<Integer> myCallable = new MyCallable();

    FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

    Thread myThread = new Thread(futureTask);

    myThread.start();

    try {
      int sum = futureTask.get();
      System.out.println("Result: "+sum);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
