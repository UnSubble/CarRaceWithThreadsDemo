import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

public class Main {

    static final int WIDTH = 850;

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(3);
        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < 10; i++) {
            vehicles[i] = new Vehicle(0, 75 * i + 30, sem);
        }
        Screen screen = new Screen(vehicles);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(vehicles[i]);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(screen, "Done!");
        screen.exit();
    }

}

