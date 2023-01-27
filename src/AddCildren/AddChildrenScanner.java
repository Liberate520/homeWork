package AddCildren;

import Homework_6.Designer_Human;

import java.util.Scanner;

import static java.lang.System.in;

public class AddChildrenScanner implements IAddCildren{
    @Override
    public void addCildren() {
        Scanner scanner = new Scanner(in);
        System.out.println("Пожалуйста, введите имя:");
        String personName = scanner.nextLine();

        Designer_Human human = new Designer_Human(personName);

        System.out.println("Пожалуйста, введите имя отца (или нажмите enter, если оно недоступно) ");
        String fatherName = scanner.nextLine();
        if (!fatherName.isEmpty()) {
            human.setFather((new Designer_Human(fatherName)));
        }

        System.out.println("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно). ");
        String motherName = scanner.nextLine();
        if (!motherName.isEmpty()) {
            human.setMother(new Designer_Human(motherName));
        }

        System.out.println("Выбранный человек : " + human);
    }
}
