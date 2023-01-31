package VIVI.AddParents;

import Homework_6.Designer_Human;

import java.util.Scanner;

import static java.lang.System.in;

public class AddParentsScanner implements IAddParents{
    Designer_Human designer_human;
    @Override
    public void addParents() {
        Scanner scanner = new Scanner(in);

        System.out.println("Введите имя отца");
        String fatherName = scanner.nextLine();
        System.out.println("Введите имя матери ");
        String motherName = scanner.nextLine();

        if (fatherName != null && !fatherName.equals("")) {
            designer_human.setFather(new Designer_Human(fatherName));
        }
        if (motherName != null && !motherName.equals("")) {
            designer_human.setMother(new Designer_Human(motherName));
        }
    }
}
