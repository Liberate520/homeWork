package HWGT.model.commands;

import HWGT.model.FamilyTree;
import HWGT.model.Person;

import java.util.List;

public class TestTree {
    private FamilyTree familyTree;
    public TestTree(FamilyTree familyTree) {this.familyTree = familyTree;}

    public  void fillTestTree(FamilyTree familyTree){
            familyTree.setPerson(new Person("Ivan1","male", 1000, 1030,"Unknown", "Unknown", List.of("Ivan2")));
            familyTree.setPerson(new Person("Ivan2","male", 1021, 1040, "Unknown", "Ivan1", List.of("Vasiliy1","Fedor1","Sofia1")));
            familyTree.setPerson(new Person("Vasiliy1","male", 1036, 1055, "Unknown", "Ivan2", List.of()));
            familyTree.setPerson(new Person("Fedor1","male", 1031, 1060, "Unknown", "Ivan2", List.of()));
            familyTree.setPerson(new Person("Sofia1","female", 1035, 1069, "Unknown", "Ivan2", List.of()));

        }
    }

