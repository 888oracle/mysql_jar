import java.awt.*;
import javax.swing.*;

public class Ball {
   private int diameter;
   private int x, y;
   private int dx, dy;
   private Color color;
   private BallWorld world;

   public Ball(BallWorld world) {
      diameter = (int) (Math.random() * 50 + 20);
      x = (int) (Math.random() * BallWorld.WIDTH + 0);
      y = (int) (Math.random() * BallWorld.HEIGHT + 0);
      dx = r.nextInt(8) - 4;
      dy = r.nextInt(8) - 4;
      color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
      this.world = world;
   }

   public void move() {
      if (x + diameter > world.getWidth() || x - diameter < 0) {
         dx = -dx;
      }
      if (y + diameter > world.getHeight() || y - diameter < 0) {
         dy = -dy;
      }
      x += dx;
      y += dy;
   }

   public void draw(Graphics g) {
      g.setColor(color);
      g.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
   }
}