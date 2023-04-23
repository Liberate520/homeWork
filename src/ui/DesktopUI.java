package ui;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopUI extends JFrame implements View {

    private JTextArea answer;
    private JButton findInfo;
    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        answer = new JTextArea();
        findInfo = new JButton("Показать всех членов семьи");
        setLayout(null);
        add(findInfo);
        add(answer);
        findInfo.setBounds(100, 20, 200, 100);
        answer.setBounds(20, 140, 340, 160);


        findInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onClick(answer.getText());
            }
        });

        setVisible(true);
    }

    @Override
    public void print(String text) {
        answer.setText(text);
    }
}