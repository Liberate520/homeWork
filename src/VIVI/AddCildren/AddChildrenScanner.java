package VIVI.AddCildren;

import Homework_6.Designer_Human;

import java.util.Scanner;

import static java.lang.System.in;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddChildrenScanner implements IAddCildren{
    @Override
    public void addCildren() {
        showMessageDialog(null,"Следуйте дальнейшим инструкциям");

        String personName = showInputDialog("Пожалуйста, введите имя:");
        Scanner scanner = new Scanner(in);
//        System.out.println("Пожалуйста, введите имя:");
//        String personName = scanner.nextLine();

        Designer_Human human = new Designer_Human(personName);
        String fatherName = showInputDialog(null,"Пожалуйста, введите имя отца (или нажмите enter, если оно " +
                "недоступно)");
//        System.out.println("Пожалуйста, введите имя отца (или нажмите enter, если оно недоступно) ");
//        String fatherName = scanner.nextLine();
        if (!fatherName.isEmpty()) {
            human.setFather((new Designer_Human(fatherName)));
        }

        String motherName = showInputDialog("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно).");
//        System.out.println("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно). ");
//        String motherName = scanner.nextLine();
        if (!motherName.isEmpty()) {
            human.setMother(new Designer_Human(motherName));
        }
        showMessageDialog(null,"\"Выбранный человек : " + human);
//        System.out.println("Выбранный человек : " + human);
    }
}
