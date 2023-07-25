package treeWorkspace;

import enums.Gender;

import java.time.LocalDate;

public class Service  {
    // Класс который руководит поведением класса FamilyTree
    private int id;
    private FamilyTree currentTree;

    public Service() {
        currentTree = new FamilyTree();
    }

    public void addPerson(String name, Gender gender, LocalDate birthDate) {
        // по умолчанию мы не знаем дату смерти, нужно потом ее добавлять с помощью метода в Person
        currentTree.addPerson(new Person(id++,name, gender, birthDate));
    }
    public FamilyTree getCurrentTree(){
        return currentTree;
    }

    public Person getPerson() {
        return null;
    }
}
