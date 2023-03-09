package model;

import java.time.LocalDate;

import model.entity.Person;
import model.entity.Sex;
import model.tree.Demo;
import model.tree.FamilyTree;

public class Service implements Model {

    private FamilyTree<Person> familyTree;

    @Override
    public void demoTree() {
        familyTree = Demo.demoTree();
    }

    @Override
    public void addTreeEntity(String name, String lastname, String sexStr, LocalDate dateOfBirth) {
        Sex sex;
        if (sexStr.equalsIgnoreCase("m") || sexStr.equalsIgnoreCase("male")) {
            sex = Sex.MALE;
        } else {
            sex = Sex.FEMALE;
        }
        familyTree.addEntity(new Person(lastname, lastname, sex, dateOfBirth));
        ;
    }

    @Override
    public String showEntityInfo(int num) {
        return familyTree.getEntityByID(num).fullInfo();

    }

    @Override
    public String printTree() {
        return familyTree.printTree();
    }

    @Override
    public void newTree() {
        familyTree = new FamilyTree<>();
    }

}
