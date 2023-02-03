package VIVI.Search;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_7.Designer_Human;

import java.util.List;
import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class SearchHuman implements ISearch {
    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)

    @Override
    public void search(List<Designer_Human> humans) {
        outer:
        for (; ; ) {
            String personName = showInputDialog("Пожалуйста, введите имя:\nИли напишите 'exit для выхода");
            iConverted.personСonvertedUpper_Lower(personName);

            for (Designer_Human сС : humans) {
                if (personName.equals(сС.getName())) {
                    showMessageDialog(null, "вывод: " + сС);

                } else {
                    showMessageDialog(null, "Нет людей с таким именем.");
                    continue outer;

                }
                if (personName.equals("exit")) {
                    break outer;
                }
                String txt2 = showInputDialog(null, "Повторить Выбор ?\nДа? Нет?");
                if (Objects.equals(txt2.toLowerCase(), "да")) {
                    continue outer;
                } else {
                    Objects.equals(txt2.toLowerCase(), "нет");
                    {
                        break outer; //я не знаю почему светит серым, но все работает
                    }
                }
            }
        }
    }
}

/*
Переделал класс, добавил вариант зацикливания через for на случай не правильного ввода, + добавил возможность через
коноль выйти из цикла.
 */