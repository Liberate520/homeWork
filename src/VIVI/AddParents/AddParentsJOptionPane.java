package VIVI.AddParents;

import Homework_6.Designer_Human;

import java.util.Scanner;

import static java.lang.System.in;
import static javax.swing.JOptionPane.showInputDialog;

public class AddParentsJOptionPane implements IAddParents{
    Designer_Human designer_human;
    @Override
    public void addParents() {
        String fatherName = showInputDialog(null, "Пожалуйста, введите имя отца (или нажмите enter, если оно " +
                "недоступно)");

        String motherName = showInputDialog("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно).");

        if (fatherName != null && !fatherName.equals("")) {
            designer_human.setFather(new Designer_Human(fatherName));
        }
        if (motherName != null && !motherName.equals("")) {
            designer_human.setMother(new Designer_Human(motherName));
        }
    }
}
