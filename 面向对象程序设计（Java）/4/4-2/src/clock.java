import java.time.*;

class ClockThread implements Runnable{
    String clock;
    ClockThread(int i){
        clock = "+0"+i+":00";
    }
    public void run(){
        this.time();
    }
    synchronized void time() {
        System.out.println(ZonedDateTime.now(ZoneId.of(this.clock)));
    }
}

class LocalClock extends ClockThread{
    LocalClock() {
        super(8);
    }
    public void run(){
        this.sleep();
        System.out.println(ZonedDateTime.now());
    }
    void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class clock {
    public static void main(String []args) {
        ClockThread localtime = new LocalClock();
        Thread thread = new Thread(localtime);
        ClockThread time1 = new ClockThread(0);
        Thread thread1 = new Thread(time1);
        ClockThread time2 = new ClockThread(4);
        Thread thread2 = new Thread(time2);
        thread.start();
        thread1.start();
        thread2.start();
        try {
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
