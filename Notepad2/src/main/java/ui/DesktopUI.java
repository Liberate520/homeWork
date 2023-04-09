package ui;

import presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesktopUI implements View{
    private Presenter presenter;

    @Override
    public void start() {

        JFrame mainMenu = new JFrame("Записная книжка");
        JButton bNew = new JButton("Создать заметку");
        JButton bAll = new JButton("Просмотреть все записи");
        JButton bChange = new JButton("Изменить заметку");
        JButton bRemove = new JButton("Удалит заметку");
        JButton bExit = new JButton("Выход");
        bNew.setBounds(20,60,190,20);
        bAll.setBounds(20,80,190,20);
        bChange.setBounds(20,100,190,20);
        bRemove.setBounds(20,120,190,20);
        bExit.setBounds(20,160,190,20);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие программы


        mainMenu.add(bNew);
        mainMenu.add(bAll);
        mainMenu.add(bChange);
        mainMenu.add(bRemove);
        mainMenu.add(bExit);
        mainMenu.setSize(250,280);
        mainMenu.setLayout(null);
        mainMenu.setVisible(true);

        bAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commandNumber = "all";
                presenter.getAnswer(commandNumber);
            }
        });
        bNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commandNumber = "new";
                presenter.getAnswer(commandNumber);
            }
        });

        bChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commandNumber = "change";
                presenter.getAnswer(commandNumber);
            }
        });

        bRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commandNumber = "remove";
                presenter.getAnswer(commandNumber);
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.dispose();
            }
        });
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        JFrame secondMenu = new JFrame("Записи");
        if (text.equals("Новая заметка")){

            JTextField inputUser = new JTextField("Текст заметки");
            inputUser.setBounds(50,100,200,30);
            secondMenu.add(inputUser);
            secondMenu.setSize(300,300);
            secondMenu.setLayout(null);
            secondMenu.setVisible(true);

            JButton saveNew = new JButton("Сохранить заметку");
            saveNew.setBounds(50,140,190,20);
            secondMenu.add(saveNew);
            saveNew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String s = inputUser.getText(); //Берем значение вводимое пользователем

                    presenter.getAnswer(s); //Используем
                    secondMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // закрытие окна на крестик
                    secondMenu.dispose();

                }
            });


        } else if (text.equals("Выход в главное меню")) {
            System.out.println("Пришло: Выход в главное меню");

        } else {

            String[] arrText = text.split("\n");
            DefaultListModel<String> note = new DefaultListModel< >();
            System.out.println(arrText[arrText.length-1]);

            if (arrText[arrText.length-1].equals(" Выберите номер заметки для изменения")){
                int size = arrText.length-1;

                String[] newArrText = new String[size];
                System.arraycopy(arrText, 0, newArrText, 0, size);

                JFrame thirdMenu = new JFrame();
                JList jList = new JList(newArrText);
                JButton checkButton = new JButton("Выбрать");


                thirdMenu.setBounds(100,100,500,300);
                JPanel panel = new JPanel();
                panel.add(jList);
                panel.add(checkButton);
                thirdMenu.add(panel);
                thirdMenu.setVisible(true);

                checkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getActionCommand().equals("Выбрать"))
                        {
                            int index = jList.getSelectedIndex();
//                            System.out.println("Index Selected: " + index);
                            presenter.getAnswer(Integer.toString(index));

                            String s = (String) jList.getSelectedValue();
//                            System.out.println("Value Selected: " + s);
                        }
                        thirdMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // закрытие окна на крестик
                        thirdMenu.dispose();

                    }
                });
            }
            if (arrText[arrText.length-1].equals(" Выход в главное меню ")){
                for (int i = 0; i < arrText.length - 1; i++) {
                    note.addElement(arrText[i]);
                }
                JList<String> jList = new JList< >(note);
                jList.setBounds(100,100,75,75);
                secondMenu.add(jList);
                secondMenu.setSize(800,600);
                secondMenu.setVisible(true);
                secondMenu.setLayout(null);

            }
            if (arrText[arrText.length-1].equals("Введите новый текст")){
                System.out.println(Arrays.toString(arrText));
                String[] arrOldText = arrText[0].split("запись:");

                JFrame fourthMenu = new JFrame();
                JLabel oldNote = new JLabel(arrOldText[1]);
                JTextField inputUser = new JTextField(arrOldText[1]);
                JButton saveNew = new JButton("Сохранить заметку");

                oldNote.setBounds(40,40,400,20);
                inputUser.setBounds(40,80,400,30);
                saveNew.setBounds(50,110,190,20);

                fourthMenu.add(oldNote);
                fourthMenu.add(inputUser);
                fourthMenu.add(saveNew);
                fourthMenu.setSize(500,300);
                fourthMenu.setLayout(null);
                fourthMenu.setVisible(true);


                saveNew.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = inputUser.getText(); //Берем значение вводимое пользователем

                        presenter.getAnswer(s); //Используем
                        fourthMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // закрытие окна на крестик
                        fourthMenu.dispose();
                    }
                });

            }
            if (arrText[arrText.length-1].equals(" Выберите номер заметки для удаления")){
                int size = arrText.length-1;

                String[] newArrText = new String[size];
                System.arraycopy(arrText, 0, newArrText, 0, size);

                JFrame thirdMenu = new JFrame();
                JList jList = new JList(newArrText);
                JButton checkButton = new JButton("Выбрать");


                thirdMenu.setBounds(100,100,500,300);
                JPanel panel = new JPanel();
                panel.add(jList);
                panel.add(checkButton);
                thirdMenu.add(panel);
                thirdMenu.setVisible(true);

                checkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getActionCommand().equals("Выбрать"))
                        {
                            int index = jList.getSelectedIndex();
//                            System.out.println("Index Selected: " + index);
                            presenter.getAnswer(Integer.toString(index));

                            String s = (String) jList.getSelectedValue();
//                            System.out.println("Value Selected: " + s);
                        }
                        thirdMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // закрытие окна на крестик
                        thirdMenu.dispose();

                    }
                });
            }

        }


    }

    @Override
    public void changeFlag() {

    }

    @Override
    public void changeFlag2() {

    }
}
