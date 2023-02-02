package VIVI.AddCildren;

import Homework_6.Designer_Human;


import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;


public class AddChildrenJOptionPane implements IAddCildren {


    @Override
    public void addCildren() {
        outer:
        for (; ; ) {
            String humann = showInputDialog("Пожалуйста введите имя человека \nк которому будем добавлять детей :");
            Designer_Human human = new Designer_Human(humann);

            String fatherName = showInputDialog(null, "Пожалуйста, введите имя отца (или нажмите enter, если оно " + "недоступно)");

            if (!fatherName.isEmpty()) {
                human.setFather((new Designer_Human(fatherName)));
            }

            String motherName = showInputDialog("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно).");

            if (!motherName.isEmpty()) {
                human.setMother(new Designer_Human(motherName));
            }
            showMessageDialog(null, "\"Выбранный человек : " + human + "\nДобавлены родители" + "Мать : " + motherName + "Отец: " + fatherName);

            String txt2 = showInputDialog(null, "Повторить Выбор ?\nДа? Нет?");
            if (Objects.equals(txt2, "Да")) {
                continue outer;
            } else {
                Objects.equals(txt2, "Нет");
                {
                    break outer; //я не знаю почему светит серым, но все работает
                }
            }


        }
    }
}




