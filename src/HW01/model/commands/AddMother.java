package HW01.model.commands;

import HW01.model.FamilyTree;
import HW01.model.Person;

import java.util.Scanner;

public class AddMother {
    private FamilyTree familyTree;

    public AddMother(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public AddMother(){ this (null);}

    public void add(FamilyTree familyTree, String personName){
        Scanner scanner1 = new Scanner(System.in);
        CheckName checkName = new CheckName(familyTree);
        System.out.println("Введите имя матери(без пробелов) или 'unknown'\n");
        String motherName = scanner1.next();
        if (!motherName.equals("unknown")){
            if (checkName.getCheck(familyTree, motherName)) {
                familyTree.getPerson(personName).setMother(motherName);
                familyTree.getPerson(motherName).addChild(personName);
            }
            else{
                familyTree.getPerson(personName).setMother(motherName);
                familyTree.setPerson(new Person(motherName,"female", 0, 0));
                familyTree.getPerson(motherName).addChild(personName);
            }
        }
    }

}
