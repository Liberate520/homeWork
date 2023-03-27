package ui.desktop;

import ui.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private View view;
    JPanel buttonPanel;

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setView(View view) {
        this.view = view;
    }

    public ButtonPanel(View view) {
        this.view = view;
        JButton b1 = new JButton("Редактировать заметку");
        JButton b2 = new JButton("Удалить заметку");
        JButton b3 = new JButton("Добавить заметку");
        JButton b4 = new JButton("Сохранить и выйти");
//        b1.setVerticalTextPosition(AbstractButton.CENTER);
//        b1.setHorizontalTextPosition(AbstractButton.CENTER);
//        b1.setSize(100,20);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.editNote();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.removeNote();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.addNote();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.exit();
            }
        });
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(b1,BorderLayout.SOUTH);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
    }
}
