package ui;

import person.Person;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopUI extends JFrame implements View {

    private Label lSearch;
    private JTextArea answer, zero;
    private TextField quiry;
    private Button findInfo;
    private Button addHuman;
    private Button getHuman;
    private Button getAll;
    private Button getByAge;
    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(1500, 600);
        lSearch = new Label("поиск: ");
        answer = new JTextArea();
        //zero = new JTextArea();
        findInfo = new Button("Найти информацию о человеке по имени");
        addHuman = new Button("Добавить человека");
        getHuman = new Button("Получить человека");
        getAll = new Button("Получить всех");
        getByAge = new Button("Получить людей младше указанного возраста");
        quiry = new TextField();

        setLayout(new GridLayout(2, 5));
        add(lSearch);
        add(quiry);
        add(answer);
        //add(zero);
        add(findInfo);
        add(addHuman);
        add(getHuman);
        add(getByAge);
        add(getAll);

        findInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.find(quiry.getText());
            }
        });

        addHuman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.addHuman(quiry.getText());
            }
        });
        getHuman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.getHuman(quiry.getText());
            }
        });
        getByAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.getByAge(quiry.getText());
            }
        });
        getAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.getAll();
            }
        });

        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void print(String text) {
        answer.setText(text);
    }
}
