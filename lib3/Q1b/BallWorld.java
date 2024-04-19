import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.Timer;
/**
 * A panel that displays a world of bouncing balls.
 */
public class BallWorld extends JPanel {
   private static final int WIDTH = 640;
   private static final int HEIGHT = 480;
   private static final int MAX_BALLS = 10;
   private static final int DELAY = 20;
   private static final Random r = new Random();

   private int currentNumBalls;
   private ArrayList<Ball> balls;
   private Timer timer;

   public BallWorld() {
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setBackground(Color.WHITE);
      setForeground(Color.BLACK);
      setFont(new Font("Serif", Font.PLAIN, 30));
      balls = new ArrayList<Ball>();

      timer = new Timer(DELAY, (ActionEvent e) -> {
         for (Ball ball : balls) {
            ball.move();
         }
         repaint();
     });
      timer.start();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (Ball ball : balls) {
         ball.draw(g);
      }
   }

   public void launchBall() {
      if (currentNumBalls < MAX_BALLS) {
         balls.add(new Ball(this));
         currentNumBalls++;
      }
   }

   public void addBall(Ball ball) {
      balls.add(ball);
      currentNumBalls++;
   }
}