package model.service;

import model.familyTree.FamilyTree;
import model.fileOperations.FileHandler;

import model.human.Gender;
import model.human.Human;



public class ServiceHuman implements Service {
    private FamilyTree<Human> tree;

    public ServiceHuman() {
        this.tree = new FamilyTree<>();
    }

    public void addTreeItem(String name, Gender gender, String birthDate,
                            Human father, Human mother) {
        tree.addTreeItem(new Human(name, gender, birthDate, father, mother));
    }

    public void addTreeItem(String name, Gender gender, String birthDate) {
        tree.addTreeItem(new Human(name, gender, birthDate));
    }

    public Human getById(long id) {
        return tree.getById(id);
    }

    public void remove(long id) {
        tree.remove(id);
    }


    public String getHumanListInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список людей: \n");
        for (Human item : tree) {
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortByGender() {
        tree.sortByGender();
    }

    public void saveAsFile(String path){
        FileHandler fileHandler = new FileHandler(path);
        fileHandler.save(tree);
    }

    public void readFromFile(String path) {
        FileHandler fileHandler = new FileHandler(path);
        fileHandler.read();
    }
}
