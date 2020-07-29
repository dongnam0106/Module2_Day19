package createthreadsimple;

public class NumberGenerator implements Runnable {
    @Override
    synchronized public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            System.out.println(hashCode());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ahihi");
            }
        }
    }
}
