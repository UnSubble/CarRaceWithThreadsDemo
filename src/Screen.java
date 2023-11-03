import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen extends JFrame{

    JPanel panel = new JPanel();

    Screen(Vehicle[] vehicles) {
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, 1000, 1000);
        panel.setLayout(null);

        for (Vehicle vehicle : vehicles) {
            vehicle.setSize(100,30);
            vehicle.setLocation(vehicle.x, vehicle.y);
            panel.add(vehicle);
        }

        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850,810);
        this.setLocation(1920 / 2 - (int)this.getSize().getWidth() / 2, 1080 / 2 - (int)this.getSize().getHeight() / 2);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Semaphore Sample");
        this.add(panel);
    }

    void exit() {
        System.exit(0);
    }
}
