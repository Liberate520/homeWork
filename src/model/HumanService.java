package model;

import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Gender;
import model.members.Human;
import model.members.Member;

import java.util.Optional;

public class HumanService {
    private FamilyTree<Human> familyTree;
    private FileManager fileManager;

    public HumanService() {
        this.familyTree = null;
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void importFile(String filePath) {
        this.fileManager = new FileManager(filePath);
        this.familyTree = fileManager.loadFile();
    }

    public void saveFile() {
        fileManager.saveFile(familyTree);
    }

    public void addRecord(String name, Gender gender, int dateOfBirth) {
        familyTree.addPersonInFamilyTree(new Human(name, gender, dateOfBirth));
    }
    public Member getRecord(String name, int year) {
        return familyTree.getHumanFromTree(name, year);
    }

    public void getAllRecord() {
        if (familyTree.getFamilyTree().isEmpty()) {
            System.out.println("Семейное древо пусто.");
        } else {
            System.out.println("Семейное древо:");
            for (Human person : familyTree) {
                System.out.println(person.getName() + " (" + person.getYearOfBirth() + ")");
            }
        }
    }

    public void getParents(String name, int yearOfBirth) {
        Member child = familyTree.getHumanFromTree(name, yearOfBirth);
        if (child != null) {
            String father = Optional.ofNullable(child.getFather()).
                    map(Member::getName).orElse("Неизвестно");
            String mother = Optional.ofNullable(child.getMother()).
                    map(Member::getName).orElse("Неизвестно");
            System.out.printf("Ребенок -> %s, отец -> %s, мать %s\n",
                    child.getName(), father, mother);
        } else {
            System.out.println("Не найден в древе");
        }
    }
}
