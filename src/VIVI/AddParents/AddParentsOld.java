package VIVI.AddParents;

import Homework_6.Designer_Human;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddParentsOld implements IAddParents {
    @Override
    public void addParents() {
        showMessageDialog(null, "Следуйте дальнейшим инструкциям");
        String human = showInputDialog("Пожалуйста, введите имя:");

        Designer_Human designer_Human = new Designer_Human(human);
        String fatherName = showInputDialog(null, "Пожалуйста, введите имя отца(Родителя) (или нажмите enter, если " +
                "оно " +
                "недоступно)");


        if (!fatherName.isEmpty()) {
            designer_Human.setFather((new Designer_Human(fatherName)));
        }
        String motherName = showInputDialog("Пожалуйста, введите имя матери(Родителя) (или нажмите enter, если оно недоступно).");

        if (!motherName.isEmpty()) {
            designer_Human.setMother(new Designer_Human(motherName));
        }
        showMessageDialog(null, "\"Выбранный человек : " + human + "\nДобавлены родители" +
                "Мать : " + motherName +
                "Отец: " + fatherName);
    }
}
