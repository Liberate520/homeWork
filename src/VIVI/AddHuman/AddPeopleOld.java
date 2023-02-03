package VIVI.AddHuman;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_7.Designer_Human;

import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddPeopleOld implements IAddHuman {


    Designer_Human designer_human;
    private static int id;

    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)


    //Поработал с инкапсуляцией
    @Override
    public void addHuman(Designer_Human human) {//с параметрами входными, там еще есть без параметров ))
        outer:
        for (; ; ) {
            String personName = showInputDialog("Пожалуйста, введите имя:");
            iConverted.personСonvertedUpper_Lower(personName);

            String personSEX = showInputDialog("Пожалуйста, введите пол:");
            iConverted.personСonvertedUpper_Lower(personSEX);

            int personDate = Integer.parseInt(showInputDialog("Пожалуйста, год рождения:"));

            human = new Designer_Human(id++, personName, personSEX, personDate);
            designer_human.getHumans().add(human);
            showMessageDialog(null, "Новый человек добавлен в список: " + human);

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
