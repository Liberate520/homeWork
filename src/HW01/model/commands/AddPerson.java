package HW01.model.commands;

import HW01.model.FamilyTree;
import HW01.model.Person;

import java.util.Scanner;

public class AddPerson {
    private FamilyTree familyTree;

    public AddPerson(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void toFamilyTree (FamilyTree familyTree){
        CheckName checkName = new CheckName(familyTree);
        String personName;
        String personSex;
        Integer birthData;
        Integer deathData;

        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName.getCheck(familyTree, personName)){
            System.out.println("такой человек уже есть в базе даных \n");
        }
        else{
            System.out.println("Введите пол");
            personSex = scanner1.next();
            System.out.println("год рождения");
            birthData = scanner1.nextInt();
            System.out.println("год смерти");
            deathData = scanner1.nextInt();

            familyTree.setPerson(new Person(personName,personSex, birthData, deathData));
            System.out.println("человек добавлен \n");
        }
    }
}
