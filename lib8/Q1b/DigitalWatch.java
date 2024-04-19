import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class DigitalWatch extends Applet implements Runnable {

    Thread t;
    String time = "";

    public void init() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.setColor(Color.BLUE);
        time = new java.util.Date().toLocaleString();
        g.drawString(time, 50, 50);
    }
}