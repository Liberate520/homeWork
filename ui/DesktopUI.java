package homeWork.ui;

import javax.swing.*;

import homeWork.presenter.Presenter;

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
    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(400, 600);
        lSearch = new Label("поиск: ");
        answer = new JTextArea();
        zero = new JTextArea();
        findInfo = new Button("Найти информацию о человеке по имени");
        addHuman = new Button("Добавить человека");
        getHuman = new Button("Получить человека");
        getAll = new Button("Получить всех");
        quiry = new TextField();

        setLayout(new GridLayout(4, 5));
        add(lSearch);
        add(quiry);
        add(answer);
        add(zero);
        add(findInfo);
        add(addHuman);
        add(getHuman);
        add(getAll);

        findInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onClickFind(quiry.getText());
            }
        });

        addHuman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onClickAddHuman(quiry.getText());
            }
        });
        getHuman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onClickGetHuman(quiry.getText());
            }
        });
        getAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onClickGetAll();
            }
        });

        setVisible(true);
    }

    @Override
    public void print(String text) {
        answer.setText(text);
    }
}