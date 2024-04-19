import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGenerator extends JFrame implements Runnable {
    private JTextField textField;
    private boolean keepRunning = true;

    public NumberGenerator() {
        setLayout(new FlowLayout());
        textField = new JTextField(10);
        add(textField);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(NumberGenerator.this);
                t.start();
            }
        });

        add(startButton);

        setTitle("Number Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run() {
        while (keepRunning) {
            for (int i = 1; i <= 100; i++) {
                textField.setText(String.valueOf(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {}
            }
        }
    }

    public static void main(String[] args) {
        new NumberGenerator();
    }
}