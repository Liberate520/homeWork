package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

import homeWorkSem1.Service.Gender;

public class Add <T extends Human> implements Serializable, Option {

    int index;

    @Override
    public void execute(FamilyTree<Human> tree) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = iScanner.nextLine();
        System.out.println("Возраст: ");
        int age = iScanner.nextInt();
        System.out.println("Введите пол Male или Female: ");
        String gender = iScanner.nextLine();
        Human human9 = new Human(name, age, Gender.valueOf(gender), null, null, index++);//чтобы не вводить сразу много данных
        tree.add(human9);
        iScanner.close();
        System.out.println("New Human is created and added to FamilyTree");
    }

    @Override
    public String description() {
        return String.format("Create New Human and add to FamilyTree");
    }
    
}
