package familyTree.model.service;

import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;
import familyTree.model.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> family;
    private FileHandler fileHandler;

    public Service() {
        family = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addToFamily(String name, LocalDate dateBirth, Gender gender) {
        Human human = new Human(name, gender, dateBirth);
        idHuman++;
        family.addToFamily(human);
    }
//
//    public void addToFamily(String name, LocalDate dateBirth, Gender gender, Human mother, Human father) {
//        Human human = new Human(name, gender, dateBirth, mother, father);
//        idHuman++;
//        family.addToFamily(human);
//    }
//    public void addToFamily(String name, LocalDate dateBirth, Gender gender, Human mother, Human father) {
//        Human human = new Human(name, dateBirth, gender);
//        if (mother != null || father != null) {
//            human = new Human(name, gender, dateBirth, mother, father);
//        }
//        idHuman++;
//        family.addToFamily(human);
//    }

    public String getFamilyInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full list of FamilyTree:\n");
        for (Human human : family) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        family.sortByName();
    }

    public void sortByAge() {
        family.sortByAge();
    }

    public void writeSerialization(String filePath) {
        fileHandler.save(family, filePath);
    }
    public Serializable readSerialization(String filePath){
        Serializable dataRead = fileHandler.read(filePath);
        return dataRead;
    }
}
