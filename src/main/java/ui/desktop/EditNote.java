package ui.desktop;

import ui.View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class EditNote {
    View view;

    public EditNote(View view, JTable table) {
        this.view = view;
        System.out.println("Нажата кнопка редактировать");
        int column = 1;
        int row = table.getSelectedRow();
        if (row > -1) {
            String value = table.getModel().getValueAt(row, column).toString();
            System.out.println(value);
            JFrame editFrame = new JFrame("Edit Note");
            editFrame.setSize(300, 200);
            editFrame.setLocationRelativeTo(null);
            JPanel editPanel = new JPanel();
            JPanel buttonPanel = new JPanel();
            JLabel editLabel = new JLabel("Введите измененный текст");
            JTextArea textField = new JTextArea(value, 5, 6);
            textField.setEditable(true);
            textField.setLocation(10,20);

            JButton b1 = new JButton("OK");
//            b1.setLocation(10, 20);
            JButton b2 = new JButton("Cancel");
//            b2.setLocation(30, 20);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String newText = textField.getText();
                    if (newText != null){
                        table.getModel().setValueAt(newText,row,column);
                        System.out.println(newText);
                        view.replaceNote(row+1, newText);
                        view.saveNote();
                        editFrame.dispatchEvent(new WindowEvent(editFrame, WindowEvent.WINDOW_CLOSING));
                        view.print("Заметка изменена");
                    }
                }
            });
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editFrame.dispatchEvent(new WindowEvent(editFrame, WindowEvent.WINDOW_CLOSING));
                }
            });
            editLabel.setVisible(true);
            editPanel.add(editLabel);
            editPanel.add(textField, BorderLayout.CENTER);
            buttonPanel.add(b1, BorderLayout.SOUTH);
            buttonPanel.add(b2, BorderLayout.SOUTH);
            editPanel.setVisible(true);
            buttonPanel.setVisible(true);
            editFrame.add(editPanel, BorderLayout.NORTH);
            editFrame.add(buttonPanel, BorderLayout.SOUTH);
            editFrame.setVisible(true);

        }
    }
}
