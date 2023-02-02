package VIVI.AddParents;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_6.Designer_Human;

import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;

public class AddParentsJOptionPane implements IAddParents {
    Designer_Human designer_human;
    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)


    @Override
    public void addParents() {
        outer:
        for (; ; ) {
            String fatherName = showInputDialog(null, "Пожалуйста, введите имя отца (или нажмите enter, если оно " +
                    "недоступно)");
            iConverted.personСonvertedUpper_Lower(fatherName);

            String motherName = showInputDialog("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно).");
            iConverted.personСonvertedUpper_Lower(motherName);

            if (fatherName != null && !fatherName.equals("")) {
                designer_human.setFather(new Designer_Human(fatherName));
            }
            if (motherName != null && !motherName.equals("")) {
                designer_human.setMother(new Designer_Human(motherName));
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