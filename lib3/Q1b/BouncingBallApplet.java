import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BouncingBallApplet extends JApplet implements ActionListener {
   BallWorld world;
   JButton launchBall;

   public void init() {
      world = new BallWorld();
      setContentPane(world);
      launchBall = new JButton("Launch Ball");
      launchBall.addActionListener(this);
      add(launchBall, BorderLayout.SOUTH);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == launchBall) {
         world.launchBall();
      }
   }
}