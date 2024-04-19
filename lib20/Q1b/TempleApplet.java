import java.applet.Applet;
import java.awt.*;

public class TempleApplet extends Applet implements Runnable {
    int x1, x2, y1, y2;

    public void init() {
        Thread t1 = new Thread(this);
        Thread t2 = new Thread(this);
        Thread t3 = new Thread(this);
        Thread t4 = new Thread(this);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public void run() {
        if (Thread.currentThread() == t1) {
            for (x1 = 0; x1 < 100; x1++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        } else if (Thread.currentThread() == t2) {
            for (y1 = 100; y1 > 0; y1--) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        } else if (Thread.currentThread() == t3) {
            for (x2 = 0; x2 < 100; x2++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        } else if (Thread.currentThread() == t4) {
            for (y2 = 0; y2 < 100; y2++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x1, 0, 100, y1);
        g.setColor(Color.WHITE);
        g.fillRect(x1, y1, 100, 100);
        g.setColor(Color.RED);
        g.fillRect(x1 + 100, y2, 100, 100);
    }
}
