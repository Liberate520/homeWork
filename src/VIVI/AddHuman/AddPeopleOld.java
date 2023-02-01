package VIVI.AddHuman;

import Homework_6.Designer_Human;

import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddPeopleOld implements IAddHuman {


    Designer_Human designer_human;
    private static int id;

    //Поработал с инкапсуляцией
    @Override
    public void addHuman(Designer_Human human) {//с параметрами входными, там еще есть без параметров ))
        String personName = showInputDialog("Пожалуйста, введите имя:");
        String personSEX = showInputDialog("Пожалуйста, введите пол:");
        int personDate = Integer.parseInt(showInputDialog("Пожалуйста, год рождения:"));

        human = new Designer_Human(id++, personName, personSEX, personDate);
        designer_human.getHumans().add(human);
        showMessageDialog(null,"Новый человек добавлен в список: "+human);
    }
}
