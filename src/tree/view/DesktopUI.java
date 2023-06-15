package tree.view;

import tree.presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopUI extends JFrame implements View {
    private JLabel jLabel;
    private JTextArea answer;
    private JTextField city;
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
        jLabel = new JLabel("Сформировать данные из гениалогического древа?");
        answer = new JTextArea();
        findInfo = new JButton("Сформировать");
//        city = new JTextField();
        setLayout(null);
        add(jLabel);
//        add(city);
        add(findInfo);
        add(answer);
        jLabel.setBounds(20, 40, 500, 25);
//        city.setBounds(70, 45, 290, 20);
        findInfo.setBounds(95, 80, 200, 50);
        answer.setBounds(20, 140, 340, 160);


        findInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.getInfo();
            }
        });

        setVisible(true);
    }

    @Override
    public void print(String text) {
        answer.setText(text);
    }
}
