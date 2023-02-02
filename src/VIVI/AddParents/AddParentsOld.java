package VIVI.AddParents;

import Converted.IConverted;
import Converted.PersonConverted;
import Homework_6.Designer_Human;

import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddParentsOld implements IAddParents {
    IConverted iConverted = new PersonConverted();//Объект класса интерфейса (Каждое слово с заглавной буквы)

    @Override
    public void addParents() {
        outer:
        for (; ; ) {
            String personName = showInputDialog("Пожалуйста, введите имя, человека к которому будем добавлять родителей :");
            iConverted.personСonvertedUpper_Lower(personName);

            Designer_Human designer_Human = new Designer_Human(personName);
            String fatherName = showInputDialog(null, "Пожалуйста, введите имя отца(Родителя) (или нажмите enter, если " +
                    "оно " +
                    "недоступно)");
            iConverted.personСonvertedUpper_Lower(fatherName);

            if (!fatherName.isEmpty()) {
                designer_Human.setFather((new Designer_Human(fatherName)));
            }
            String motherName = showInputDialog("Пожалуйста, введите имя матери(Родителя) (или нажмите enter, если оно недоступно).");
            iConverted.personСonvertedUpper_Lower(motherName);

            if (!motherName.isEmpty()) {
                designer_Human.setMother(new Designer_Human(motherName));
            }
            showMessageDialog(null, "\"Выбранный человек : " + personName + "\nДобавлены родители" +
                    "Мать : " + motherName +
                    "Отец: " + fatherName);

            String txt2 = showInputDialog(null, "Повторить Выбор ?\nДа? Нет?");
            if (Objects.equals(txt2.toLowerCase(), "да")) {
                continue outer; //я не знаю почему светит серым, но все работает
            } else {
                Objects.equals(txt2.toLowerCase(), "нет");
                {
                    break outer; //я не знаю почему светит серым, но все работает
                }
            }
        }
    }
}
