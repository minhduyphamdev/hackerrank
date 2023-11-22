import java.util.concurrent.*;
import java.util.*;

class YieldExample implements Runnable {

  @Override
  public void run() {
    // TODO Auto-generated method stub
    for(int i=1;i<=5;i++) {
      System.out.println(Thread.currentThread().getName()+": "+i);
      Thread.yield();
    }

  }
}

class Data {
  private String packet;

  private boolean transfer = true;

  public synchronized String receive() {
    while(transfer) {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("CurrentThread stop "+Thread.currentThread().getName());
    }
    }
    transfer = true;
    
    String returnPacket = packet;
    notifyAll();
    return returnPacket;
  }

   public synchronized void send(String packet) {
        while (!transfer) {
            try { 
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted");
            }
        }
        transfer = false;
        
        this.packet = packet;
        notifyAll();
    }
}

class Sender implements Runnable {
    private Data data;
 
    // standard constructors
 
    public Sender(Data data) {
      this.data = data;
    }

    public void run() {
        String packets[] = {
          "First packet",
          "Second packet",
          "Third packet",
          "Fourth packet",
          "End"
        };
 
        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted"); 
            }
        }
    }
}

class Receiver implements Runnable {
    private Data load;
 
    // standard constructors
 
    public Receiver(Data load) {
      this.load = load;
    }

    public void run() {
        for(String receivedMessage = load.receive();
          !"End".equals(receivedMessage);
          receivedMessage = load.receive()) {
            
            System.out.println(receivedMessage);

            //Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted"); 
            }
        }
    }
}

public class ThreadDemo {
  public static void main(String[] args) {
    Data data = new Data();
    Thread sender = new Thread(new Sender(data));
    Thread receiver = new Thread(new Receiver(data));
    
    sender.start();
    receiver.start();
  //   YieldExample yieldExample = new YieldExample();

  //   Thread thread1 = new Thread(yieldExample, "Thread 1");
  //   Thread thread2 = new Thread(yieldExample, "Thread2");

  //   thread1.start();

  //   try {
  //     thread1.join();
  //   } catch (InterruptedException e) {
  //     e.printStackTrace();
  //   }

  //   thread2.start();

  }
  
}
