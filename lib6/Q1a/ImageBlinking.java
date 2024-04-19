import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageBlinking extends JFrame {

    private JLabel imageLabel;
    private Timer blinkTimer;

    public ImageBlinking() {
        setTitle("Image Blinking Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "path_to_your_image.jpg" with the actual path to your image
        imageLabel = new JLabel(imageIcon);

        add(imageLabel);

        // Initialize the Timer to toggle image visibility every 500 milliseconds (half a second)
        blinkTimer = new Timer(500, new ActionListener() {
            boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                imageLabel.setVisible(visible);
                visible = !visible;
            }
        });

        blinkTimer.start(); // Start the Timer to begin blinking the image
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageBlinking().setVisible(true);
            }
        });
    }
}
