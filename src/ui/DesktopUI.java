package ui;


import essence.Human;
import presenter.Presenter;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class DesktopUI extends JFrame implements View {

    private JTextArea answer;
    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(920, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        answer = new JTextArea();
        JButton findInfo = new JButton("Показать всех членов семьи");
        setLayout(null);
        add(answer);
        answer.setBounds(20, 140, 340, 160);
        findInfo.setBounds(400,10,250,40);
        JButton getRelatives = new JButton("Показать родственников");
        getRelatives.setBounds(400,70, 200,40);
        add(findInfo);
        add(getRelatives);
        JComboBox <String> members = new JComboBox<>();
        for (String human:presenter.getMembers()) {
            members.addItem(human);
        }
        add(members);
        members.setBounds(650, 140,200,50);
        findInfo.addActionListener(e -> presenter.onClick(answer.getText()));
        String x = (String) members.getSelectedItem();
        getRelatives.addActionListener(a -> presenter.onRoll(x));
        JButton save = new JButton("Сохранить семью");
        save.setBounds(400,130,150,40);
        add(save);
        save.addActionListener(e-> {
            try {
                presenter.save();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton load = new JButton("Загрузить семью");
        load.setBounds(400,180,150,40);
        add(load);
        load.addActionListener(l-> {
            try {
                presenter.load();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        setVisible(true);
    }

    @Override
    public void print(String text) {
        answer.setText(text);
    }
}