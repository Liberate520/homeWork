package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Service.Gender;

public class Add <T extends Human> implements Serializable, Option {
    
    Scanner scanner = new Scanner(System.in);
    int index;
    Gender gend;
    
    @Override
    public String description() {
        return String.format("Create New Human and add to FamilyTree");
    }

    @Override
    public void exucute(FamilyTree<Human> tree) {
        System.out.printf("Введите имя");
        String name = scanner.nextLine();
        System.out.printf("Введите возраст");
        int age = scanner.nextInt();
        System.out.printf("Введите пол Male/Female");
        String gender = scanner.next();
        gend.setGender(gender);
        Human human = new Human(name, age, gend, null, null, ++ index);
        tree.add(human);  
    }  
}
