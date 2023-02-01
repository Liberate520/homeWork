package VIVI.AddCildren;

import Homework_6.Designer_Human;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddChildrenJOptionPane implements IAddCildren {
    @Override
    public void addCildren() {
        showMessageDialog(null, "Следуйте дальнейшим инструкциям");

        String humann = showInputDialog("Пожалуйста, введите имя:");


        Designer_Human human = new Designer_Human(humann);
        String fatherName = showInputDialog(null, "Пожалуйста, введите имя отца (или нажмите enter, если оно " +
                "недоступно)");

        if (!fatherName.isEmpty()) {
            human.setFather((new Designer_Human(fatherName)));
        }

        String motherName = showInputDialog("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно).");

        if (!motherName.isEmpty()) {
            human.setMother(new Designer_Human(motherName));
        }
        showMessageDialog(null, "\"Выбранный человек : " + human + "\nДобавлены родители" +
                "Мать : " + motherName +
                "Отец: " + fatherName);
    }
}
