package createthreadsimple;

public class Threads {
    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator();
        NumberGenerator numberGenerator2 = new NumberGenerator();

        Thread t1 = new Thread(numberGenerator1);
        Thread t2 = new Thread(numberGenerator1);

        t1.start();
        t2.start();
    }
}
