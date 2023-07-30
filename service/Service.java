package homeWork.model.service;

import java.io.Serializable;
import java.time.LocalDate;

import homeWork.model.FamilyTree.FamilyTree;
import homeWork.model.fileHandler.FileHandler;
import homeWork.model.fileHandler.Writable;
import homeWork.model.human.Human;
import homeWork.model.human.gender.Gender;

public class Service implements Serializable, Writable {
    private long id;
    private FamilyTree<Human> familyTree;
    FileHandler fileHandler = new FileHandler();

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate ofLocalDate, int age, int id) {
        Human human = new Human(name, gender, ofLocalDate, age, id++);
        familyTree.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(familyTree.size());
        sb.append(" объектов: \n ");
        for (Human human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void addHuman(String name, int age) {
        Human human = new Human(name, age);
        familyTree.addHuman(human);
    }

    public void saveInFile() {
        fileHandler.save(familyTree, "/Users/xenia_golb/Desktop/familyTree/homeWork");
        System.out.println("экспорт (tree.out) завершен успешно");

    }

    public void addChild(String name, int age) {
        Human human = new Human(name, age);
        familyTree.addHuman(human);
    }

    public void addParent(String name, int age) {
        Human human = new Human(name, age);
        familyTree.addHuman(human);
    }

    public void readFromFile() {
        FamilyTree familyTree = (FamilyTree) fileHandler.read("/Users/xenia_golb/Desktop/familyTree/homeWork");
        System.out.println("Импорт данных выполнен  >>>>>>  " + familyTree);

    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Object read(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
}