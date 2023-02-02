package VIVI.AddHuman;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_6.Designer_Human;

import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddHumanSimpleNew implements IAddHumanSimple {
    Designer_Human designer_human;
    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)


    @Override
    public void addHumanSimple() {
        outer:
        for (; ; ) {
            String personName = showInputDialog("Пожалуйста, введите имя:");
            iConverted.personСonvertedUpper_Lower(personName);

            String personSEX = showInputDialog("Пожалуйста, введите пол:");
            iConverted.personСonvertedUpper_Lower(personName);

            int personDate = Integer.parseInt(showInputDialog("Пожалуйста, год рождения:"));

            Designer_Human designer_human1 = new Designer_Human(personName, personSEX, personDate);
            designer_human.getHumans().add(designer_human1);

            showMessageDialog(null, "Новый человек добавлен в список: " + designer_human1);

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


