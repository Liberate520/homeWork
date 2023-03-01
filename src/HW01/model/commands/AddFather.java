package HW01.model.commands;

import HW01.model.FamilyTree;
import HW01.model.Person;

import java.util.Scanner;

public class AddFather {

    private FamilyTree familyTree;

    public AddFather(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public AddFather(){ this (null);}

    public void add (FamilyTree familyTree, String personName){
        Scanner scanner1 = new Scanner(System.in);
        CheckName checkName = new CheckName(familyTree);
        System.out.println("Введите имя отца(без пробелов) или 'unknown'\n");
        String fatherName = scanner1.next();
        if (!fatherName.equals("unknown")){
            if (checkName.getCheck(familyTree, fatherName)) {
                familyTree.getPerson(personName).setFather(fatherName);
                familyTree.getPerson(fatherName).addChild(personName);
            }
            else{
                familyTree.getPerson(personName).setFather(fatherName);
                familyTree.setPerson(new Person(fatherName,"male", 0, 0));
                familyTree.getPerson(fatherName).addChild(personName);
            }
        }
    }
}
