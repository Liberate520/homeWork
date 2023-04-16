package ui;

import model.TreeFamily.TreeFamily;
import model.human.Human;
import presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desctop extends JFrame implements View {

    private JLabel lCity;
    private JTextArea answer;
    private JTextField name;
    private JTextField family;
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
        lCity = new JLabel("Город: ");
        answer = new JTextArea();
        findInfo = new JButton("Узнать погоду");
        name = new JTextField();
        family = new JTextField();
        setLayout(null);
        add(lCity);
        add(name);
        add(family);
        add(findInfo);
        add(answer);
        lCity.setBounds(20, 40, 50, 25);
        name.setBounds(70, 45, 100, 20);
        name.setBounds(180, 45, 100, 20);
        findInfo.setBounds(95, 80, 200, 50);
        answer.setBounds(20, 140, 340, 160);

        findInfo.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.addHuman(family.getText(), name.getText());
                //presenter.addFamily(family.getText());//при нажатии на кнопу в презентер передается информация из текстового поля
            }
        });

        setVisible(true);//делает окно видимым
    }

    @Override
    public void print(Human human) {
        //пишет text  в поле для ответов
        answer.setText(human.toString());
    }

    @Override
    public void printTree(TreeFamily tree) {


    }
}
