package com.romanovcopy.gmail.Genealogy.services;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultilineInput {
    private String[] results;
    private String[]options;

    public MultilineInput(String[]options){
        this.options=options;
    }

    public  String[] input() {
        JFrame frame = new JFrame("Multiline Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] options = {"Заголовок 1", "Заголовок 2", "Заголовок 3"};
        JTextArea[] textAreas = new JTextArea[options.length];

        for (int i = 0; i < options.length; i++) {
            JLabel titleLabel = new JLabel(options[i]);
            JTextArea textArea = new JTextArea(5, 20);
            JScrollPane scrollPane = new JScrollPane(textArea);

            panel.add(titleLabel, BorderLayout.NORTH);
            panel.add(scrollPane, BorderLayout.CENTER);

            textAreas[i] = textArea;
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton acceptButton = new JButton("Принять");
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                results = getResultsFromTextAreas(textAreas);
                closeWindow(frame);
            }
        });

        JButton cancelButton = new JButton("Отмена");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelInput();
                closeWindow(frame);
            }
        });

        buttonPanel.add(acceptButton);
        buttonPanel.add(cancelButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        return results;
    }

    private String[] getResultsFromTextAreas(JTextArea[] textAreas) {
        String[] results = new String[textAreas.length];
        for (int i = 0; i < textAreas.length; i++) {
            results[i] = textAreas[i].getText();
        }
        return results;
    }

    private void cancelInput() {
        results = null;
    }

    private void closeWindow(JFrame frame) {
        frame.dispose();
    }

    public String[] getResults() {
        return results;
    }
}













