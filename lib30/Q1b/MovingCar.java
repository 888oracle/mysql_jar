import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class MovingCar extends Applet implements Runnable {
    private int x = 0;
    private int y = 150;
    private Thread thread;

    public void init() {
        setSize(400, 300);
        setBackground(Color.WHITE);
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x += 5;
            if (x >= getWidth()) {
                x = 0;
            }
            repaint();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 40, 30);
        g.setColor(Color.BLACK);
        g.fillOval(x + 5, y + 25, 10, 10);
        g.fillOval(x + 25, y + 25, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(x + 10, y - 20, 20, 20);
        g.setColor(Color.BLACK);
        g.fillRect(x + 15, y - 17, 10, 10);
        g.setColor(Color.CYAN);
        g.drawRect(x + 2, y + 5, 10, 10);
    }
}
