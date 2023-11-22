public class ThreadLocalExample {
  private static ThreadLocal<Integer> threadLocalVariable = new ThreadLocal<>();

  public static void main(String[] args) {
      // Set values for each thread
      Thread t1 = new Thread(() -> {
          threadLocalVariable.set(1);
          System.out.println("Thread 1: " + threadLocalVariable.get());
      });

      Thread t2 = new Thread(() -> {
          System.out.println("Thread 2: " + threadLocalVariable.get());
      });

      // Start threads
      t1.start();
      t2.start();
  }
}
