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
    private JLabel lTitleAddGender;
    private JLabel lTitleBirth;
    private JLabel lTitleDateBirth;

    private JLabel lTitleAddHuman1;
    private JLabel lTitleAddFamily1;
    private JLabel lTitleAddName1;
    private JLabel lTitleAddGender1;
    private JLabel lTitleBirth1;
    private JLabel lTitleDateBirth1;

    private JLabel lTitleAddad;
    private JTextField inputFamily;//Поле ввода текста
    private JTextField inputName;
    private JTextField inputGender;
    private JTextField inputDateBirth;
    private JTextField inputFamily1;//Поле ввода текста
    private JTextField inputName1;
    private JTextField inputGender1;
    private JTextField inputDateBirth1;

    private JButton showTree;
    private JButton clearTree;
    private JButton buttonAddHuman;
    private JButton buttonsearchHuman;
    private JButton buttonsearchPresents;
    private JButton buttonsearchChild;
    private JButton buttonAddFather;
    private JButton buttonAddMather;
    private JButton buttonAddChild;

    private Presenter presenter;
    private JTextArea tree;//Поле вывода дерева

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(800, 720);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lTitle = new JLabel("Родословное древо семьи Базаровых");
        showTree = new JButton("Вывести генеалогическое древо");
        clearTree = new JButton("Очистить древо");
        tree = new JTextArea();


        lTitleAddHuman = new JLabel("Введите данные человека");
        lTitleAddFamily = new JLabel("Фамилия");
        inputFamily = new JTextField();
        lTitleAddName = new JLabel("Имя");
        inputName = new JTextField();
        lTitleAddGender = new JLabel("Пол");
        inputGender = new JTextField();
        lTitleBirth = new JLabel("Дата рождения");
        lTitleDateBirth = new JLabel("Число");
        inputDateBirth = new JTextField();
        buttonAddHuman = new JButton("Добавить человека");
        buttonsearchHuman = new JButton("Найти человека");
        buttonsearchPresents = new JButton("Найти родителей");
        buttonsearchChild = new JButton("Вывести список детей");

        lTitleAddad = new JLabel("Введите данные отца (матери, ребенка)");
        lTitleAddFamily1 = new JLabel("Фамилия");
        inputFamily1 = new JTextField();
        lTitleAddName1 = new JLabel("Имя");
        inputName1 = new JTextField();
        lTitleAddGender1 = new JLabel("Пол");
        inputGender1 = new JTextField();
        lTitleBirth1 = new JLabel("Дата рождения");
        lTitleDateBirth1 = new JLabel("Число");
        inputDateBirth1 = new JTextField();
        buttonAddFather = new JButton("Добавить отца");
        buttonAddMather = new JButton("Добавить мать");
        buttonAddChild = new JButton("Добавить ребенка");


        //city = new JTextField();
        setLayout(null);
        add(lTitle);
        add(showTree);
        add(clearTree);
        add(tree);
        add(lTitleAddHuman);
        add(lTitleAddFamily);
        add(inputName);
        add(inputFamily);
        add(lTitleAddName);
        add(buttonAddHuman);
        add(buttonsearchHuman);
        add(buttonsearchPresents);
        add(buttonsearchChild);
        add(lTitleAddGender);
        add(inputGender);
        add(lTitleBirth);
        add(lTitleDateBirth);
        add(inputDateBirth);

        add(lTitleAddad);
        add(lTitleAddFamily1);
        add(lTitleAddName1);
        add(inputName1);
        add(inputFamily1);
        add(lTitleAddGender1);
        add(inputGender1);
        add(lTitleBirth1);
        add(lTitleDateBirth1);
        add(inputDateBirth1);
        add(buttonAddFather);
        add(buttonAddMather);
        add(buttonAddChild);



        // add(lTitleAddBirthdate);
        //add(inputBirthdate);
        lTitle.setBounds(20, 10, 240, 25);
        showTree.setBounds(270, 10, 240, 25);
        clearTree.setBounds(520, 10, 240, 25);
        tree.setBounds(20, 50, 740, 300);
        lTitleAddHuman.setBounds(20, 360, 350,25);
        lTitleAddFamily.setBounds(20,390,150, 25);
        inputFamily.setBounds(110,390,200,25);
        lTitleAddName.setBounds(20, 420, 150, 25);
        inputName.setBounds(110, 420, 200,25);
        lTitleAddGender.setBounds(20, 450, 200,25);
        inputGender.setBounds(110, 450, 200,25);
        lTitleBirth.setBounds(20, 480, 200,25);
        lTitleDateBirth.setBounds(20, 510, 40,25);
        inputDateBirth.setBounds(65, 510, 40,25);
        buttonAddHuman.setBounds(20, 540, 310, 25);
        buttonsearchHuman.setBounds(20, 570, 310, 25);
        buttonsearchPresents.setBounds(20, 600, 310, 25);
        buttonsearchChild.setBounds(20, 630, 310, 25);

        lTitleAddad.setBounds(410,360, 350,25);
        lTitleAddFamily1.setBounds(410,390,150, 25);
        inputFamily1.setBounds(510,390,200,25);
        lTitleAddName1.setBounds(410, 420, 150, 25);
        inputName1.setBounds(510, 420, 200,25);
        lTitleAddGender1.setBounds(410, 450, 200,25);
        inputGender1.setBounds(510, 450, 200,25);
        lTitleBirth1.setBounds(410, 480, 200,25);
        lTitleDateBirth1.setBounds(410, 510, 40,25);
        inputDateBirth1.setBounds(465, 510, 40,25);
        buttonAddFather.setBounds(410, 540, 310,25);
        buttonAddMather.setBounds(410, 570, 310,25);
        buttonAddChild.setBounds(410, 600, 310,25);



        showTree.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                printTree();
            }
        });

        clearTree.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.clearTree();
            }
        });

        buttonAddHuman.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                addHuman();
            }
        });

        buttonsearchHuman.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                tree.setText(presenter.searchHuman(inputFamily.getText(), inputName.getText()));
            }
        });

        buttonsearchPresents.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                tree.setText(presenter.searchParents(inputFamily.getText(), inputName.getText()));
            }
        });

        buttonsearchChild.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                //tree.setText(presenter.searchChild(inputFamily.getText(), inputName.getText()));
                searchChild();
            }
        });

        setVisible(true);//делает окно видимым
    }


    @Override
    public void printTree() {
        tree.setText(presenter.getTree().getInfo());

    }
    @Override
    public void printHuman(Human human) {
        tree.setText(human.getInfo());

    }

    @Override
    public void addHuman() {

        presenter.addHuman(inputFamily.getText(), inputName.getText());
    }

    @Override
    public void searchChild() {

        tree.setText(presenter.searchChild(inputFamily.getText(), inputName.getText()));
    }
}
