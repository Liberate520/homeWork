package ui.desktop;

import ui.View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            //todo some logic
            JPanel editPanel = new JPanel();
            JLabel editLabel = new JLabel("Введите измененный текст");
            JTextField textField = new JTextField(100);
            textField.setEditable(true);
            textField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {

                }

                @Override
                public void removeUpdate(DocumentEvent e) {

                }

                @Override
                public void changedUpdate(DocumentEvent e) {

                }
            });
            editLabel.setVisible(true);
            editPanel.add(editLabel);
            editPanel.add(textField);
            editPanel.setVisible(true);
            editFrame.add(editPanel);
            editFrame.setVisible(true);

        }
    }
}
