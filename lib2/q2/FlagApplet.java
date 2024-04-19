import java.applet.Applet;
import java.awt.*;

public class FlagApplet extends Applet implements Runnable {
    Thread flagThread1, flagThread2;

    public void init() {
        flagThread1 = new Thread(this);
        flagThread1.start();
        flagThread2 = new Thread(this);
        flagThread2.start();
    }

    public void paint(Graphics g) {
        g.drawLine(0, 0, 100, 100);
        g.drawLine(100, 100, 200, 200);
        g.drawLine(0, 100, 100, 0);
    }

    public void run() {
        if (Thread.currentThread() == flagThread1) {
            drawFlag1();
        } else if (Thread.currentThread() == flagThread2) {
            drawFlag2();
        }
    }

    public void drawFlag1() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void drawFlag2() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}