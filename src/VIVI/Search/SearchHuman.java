package VIVI.Search;

import Homework_6.Designer_Human;

import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class SearchHuman implements ISearch {
    @Override
    public void search(List<Designer_Human> humans) {

        String personName = showInputDialog("Пожалуйста, введите имя:\nИли напишите 'exit для выхода");
        outer:
        for (; ; ) {
            for (Designer_Human сС : humans) {
                if (personName.equals(сС.getName())) {
                    showMessageDialog(null, "вывод: " + сС);

                } else {
                    showMessageDialog(null, "Нет людей с таким именем.");
                    continue outer;

                } if (personName.equals("exit")) {
                    break outer;
                }
            }
        }
    }
}

/*
Переделал класс, добавил вариант зацикливания через for на случай не правильного ввода, + добавил возможность через
коноль выйти из цикла.
 */