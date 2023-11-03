import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Vehicle extends JLabel implements Runnable{
    int x;
    int y;
    Semaphore sem;
    Random random;

    Vehicle(int x, int y, Semaphore sem) {
        this.x = x;
        this.y = y;
        this.sem = sem;
        random = new Random();
        setIcon(new ImageIcon("car" + new Random().nextInt(8) + ".png"));
    }
    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (x < Main.WIDTH) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x += random.nextInt(100);
            this.setLocation(x, y);
        }
        sem.release();

    }

}
