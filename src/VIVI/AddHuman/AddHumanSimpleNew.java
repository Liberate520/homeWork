package VIVI.AddHuman;

import Homework_6.Designer_Human;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddHumanSimpleNew implements IAddHumanSimple {
    Designer_Human designer_human;

    @Override
    public void addHumanSimple() {
        String personName = showInputDialog("Пожалуйста, введите имя:");
        String personSEX = showInputDialog("Пожалуйста, введите пол:");
        int personDate = Integer.parseInt(showInputDialog("Пожалуйста, год рождения:"));

        Designer_Human designer_human1 = new Designer_Human(personName, personSEX, personDate);
        designer_human.getDesigner_human().add(designer_human1);

        showMessageDialog(null, "Новый человек добавлен в список: " + designer_human1);
    }
}

