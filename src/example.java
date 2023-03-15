import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class example {
    public static void main(String args[]) {
        JFrame JFrame = new JFrame("example");
        JButton JButton = new JButton("click me");
        JButton.setBounds(80, 90, 85, 20);
        JFrame.add(JButton);
        JFrame.setSize(300, 600);
        JFrame.setLayout(null);
        JFrame.setVisible(true);

        JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Нажал");;
            }
        });
    }
}