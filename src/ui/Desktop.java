package ui;

import model.human.Human;
import presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desktop extends JFrame implements View {

    private JLabel lTitle;//Текстовые надписи
    private JLabel lTitleAddHuman;
    private JLabel lTitleAddFamily;
    private JLabel lTitleAddName;
    private JTextField inputFamily;//Поле ввода текста
    private JTextField inputName;

//    private JTextArea inputDateBirth;
//    private JTextArea inputMonthBirth;
//    private JTextArea inputYearBirth;
//    private JTextField city;
    private JButton showTree;
    private JButton buttonAddHuman;
    private JButton buttonsearchHuman;
    private JButton buttonsearchMather;
    private Presenter presenter;
    private JTextArea tree;//Поле вывода дерева

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(800, 800);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lTitle = new JLabel("Родословное древо семьи Базаровых");
        buttonAddHuman = new JButton("Добавить человека");
//        buttonAddHuman = new JButton("Добавить человека");
        lTitleAddHuman = new JLabel("Введите данные, чтобы добавить человека");
        lTitleAddFamily = new JLabel("Фамилия");
        inputFamily = new JTextField();
        lTitleAddName = new JLabel("Имя");
        inputName = new JTextField();
        tree = new JTextArea();
        buttonsearchHuman = new JButton("Найти человека");
        buttonsearchMather = new JButton("Найти мать");

//        lTitleBirth = new JLabel("Дата рождения");
//        lTitleDateBirth = new JLabel("Число");
//        // inputBirthdate = new JTextArea();
//        buttonAddHuman = new JButton("Добавить");
        showTree = new JButton("Вывести генеалогическое древо");


        //city = new JTextField();
        setLayout(null);
        add(lTitle);
        add(showTree);
        add(tree);
        add(lTitleAddHuman);
        add(lTitleAddFamily);
        add(inputName);
        add(inputFamily);
        add(lTitleAddName);
        add(buttonAddHuman);
        add(buttonsearchHuman);
        add(buttonsearchMather);
        // add(lTitleAddBirthdate);
        //add(inputBirthdate);
        lTitle.setBounds(40, 10, 400, 25);
        buttonAddHuman.setBounds(410, 170, 300, 40);
        lTitleAddHuman.setBounds(410, 55, 350,25);
        lTitleAddFamily.setBounds(410,95,150, 25);
        inputFamily.setBounds(500,95,200,25);
        lTitleAddName.setBounds(410, 135, 150, 25);
        inputName.setBounds(500, 135, 200,25);
        showTree.setBounds(20, 55, 360, 25);
        tree.setBounds(20, 95, 360,650);
        buttonsearchHuman.setBounds(410, 220, 300, 40);
        buttonsearchMather.setBounds(410, 280, 300, 40);



        showTree.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.addHuman(inputFamily.getText(), inputName.getText());
                printTree();
                //при нажатии на кнопу в презентер передается информация из текстового поля
            }
        });

        buttonAddHuman.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
               // presenter.addHuman(inputFamily.getText(), inputName.getText());
                printTree();
                //при нажатии на кнопу в презентер передается информация из текстового поля
            }
        });

        buttonsearchHuman.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                //presenter.searchHuman(inputFamily.getText(), inputName.getText());
                printHuman(presenter.searchHuman(inputFamily.getText(), inputName.getText()));

                //при нажатии на кнопу в презентер передается информация из текстового поля
            }
        });

        buttonsearchMather.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                //presenter.searchHuman(inputFamily.getText(), inputName.getText());
                printHuman(presenter.searchMather(inputFamily.getText(), inputName.getText()));

                //при нажатии на кнопу в презентер передается информация из текстового поля
            }
        });

        setVisible(true);//делает окно видимым
    }

//    @Override
//    public void print(Human human) {
//        //пишет text  в поле для ответов
//        inputFamily.setText(human.toString());
//    }

    @Override
    public void printTree() {
        tree.setText(presenter.getTree().getInfo());

    }
    @Override
    public void printHuman(Human human) {
        tree.setText(human.getInfo());

    }
}
