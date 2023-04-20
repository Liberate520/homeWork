package service.tree;

import java.util.Scanner;

import service.Persons.Human;

public class FindHuman<Person> {
    public void findHuman(FamilyTree familyTree) {
        System.out.println("Введите имя для поиска:");
        Scanner sc1 = new Scanner(System.in, "cp866");
        String name = sc1.nextLine();

        boolean find = false;

        for (int i = 0; i < familyTree.size(); i++) {
            if (((Human) familyTree.get(i)).getName().toLowerCase().equals(name.toLowerCase())) {
                System.out.println(familyTree.get(i));
                find = true;
            }
        }

        if (!find) {
            System.out.println("Такой человек не найден.");
        }
    }
}
