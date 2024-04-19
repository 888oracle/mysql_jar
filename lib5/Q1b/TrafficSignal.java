import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class TrafficSignal extends Applet implements Runnable {
    private Thread thread;
    private boolean running;

    private int signalState; // 0: Red, 1: Yellow, 2: Green

    @Override
    public void init() {
        setSize(200, 400); // Set the applet size
        setBackground(Color.WHITE);

        signalState = 0; // Start with Red signal
        running = true;
        thread = new Thread(this);
        thread.start(); // Start the thread
    }

    @Override
    public void run() {
        while (running) {
            try {
                // Sleep for signal duration (Red: 3 sec, Yellow: 1 sec, Green: 5 sec)
                switch (signalState) {
                    case 0:
                        Thread.sleep(3000); // Red signal
                        signalState = 1; // Change to Yellow
                        break;
                    case 1:
                        Thread.sleep(1000); // Yellow signal
                        signalState = 2; // Change to Green
                        break;
                    case 2:
                        Thread.sleep(5000); // Green signal
                        signalState = 0; // Change to Red
                        break;
                }

                repaint(); // Update the applet
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int signalWidth = 80;
        int signalHeight = 200;

        g.setColor(Color.BLACK);
        g.fillRect(centerX - signalWidth / 2, centerY - signalHeight / 2, signalWidth, signalHeight);

        switch (signalState) {
            case 0:
                g.setColor(Color.RED);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
            case 2:
                g.setColor(Color.GREEN);
                break;
        }

        int lightSize = 50;
        g.fillOval(centerX - lightSize / 2, centerY - lightSize / 2 - 70, lightSize, lightSize); // Red light
        g.fillOval(centerX - lightSize / 2, centerY - lightSize / 2, lightSize, lightSize); // Yellow light
        g.fillOval(centerX - lightSize / 2, centerY - lightSize / 2 + 70, lightSize, lightSize); // Green light
    }

    @Override
    public void destroy() {
        running = false;
        thread.interrupt(); // Stop the thread
    }
}
