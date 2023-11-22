class SharedCounter {
  private volatile int counter = 0;

  public void increment() {
    System.out.println("Current thread: "+Thread.currentThread().getName()+ " " + counter);
  }

  public int getCounter() {
    return counter;
  }
}

public class VolatileRaceConditionExample {
  public static void main(String[] args) {
    final SharedCounter sharedCounter = new SharedCounter();

    Thread thread1 = new Thread(() -> {
      for(int i=0;i<10;i++) {
        sharedCounter.increment();
      }
    },"thread1");

    Thread thread2 = new Thread(() -> {
      for(int i=0;i<10;i++) {
        sharedCounter.increment();
      }
    },"thread2");

    thread1.start();
    
    try {
      thread1.join();
      // thread2.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    thread2.start();
    System.out.println("Final Counter Value: " + sharedCounter.getCounter());

  }
}
 