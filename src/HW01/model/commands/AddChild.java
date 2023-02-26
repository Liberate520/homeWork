package HW01.model.commands;

import HW01.model.FamilyTree;
import HW01.model.Person;

import java.util.Scanner;

public class AddChild {
    private FamilyTree familyTree;

    public AddChild(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public AddChild(){ this(null); };

    public void add (FamilyTree familyTree, String personName){
        Scanner scanner1 = new Scanner(System.in);
        CheckName checkName = new CheckName(familyTree);
        System.out.println("Введите имя ребенка(без пробелов) или 'unknown'\n");
        String childName = scanner1.next();

        if (!childName.equals("unknown")){
            if (checkName.getCheck(familyTree, childName)) {
            }
            else{
                System.out.println("Введите пол ребенка\n");
                String childSex = scanner1.next();
                familyTree.setPerson(new Person(childName,childSex, 0, 0));

            }
            familyTree.getPerson(personName).addChild(childName);
            if (familyTree.getPerson(personName).getSex().equals("male")){
                familyTree.getPerson(childName).setFather(personName);
            }else{
                familyTree.getPerson(childName).setMother(personName);
            }
        }
    }
}

