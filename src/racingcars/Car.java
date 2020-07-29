package racingcars;

import com.sun.xml.internal.bind.v2.util.EditDistance;
import org.omg.PortableInterceptor.DISCARDING;
import sun.applet.Main;

import java.util.Random;

import static racingcars.Main.DISTANCE;
import static racingcars.Main.STEP;

public class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;

        long startTime = System.currentTimeMillis();

        while (runDistance < DISTANCE) {
            try {
                int speed = (new Random()).nextInt(20);
                runDistance += speed;

                String log = "|";
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i+= STEP) {
                    if (percentTravel >= i + STEP) {
                        log += "=";
                    }else if(percentTravel >= i && percentTravel < i + STEP){
                        log += "0";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
