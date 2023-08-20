package genealogy_tree.model.service;

import genealogy_tree.model.Human.Gender;
import genealogy_tree.model.Human.Human;
import genealogy_tree.model.Tree.GeneologiTree;

import genealogy_tree.model.WriterAndReader.FileHandler;

import java.time.LocalDate;


public class Service {
    private GeneologiTree tree;

    private FileHandler fileHandler;


    public Service() {
        tree = new GeneologiTree();
        fileHandler = new FileHandler();
    }

    public void sortByName() {
        tree.sortByName();
    }


    public void sortByAge() {
        tree.sortByAge();
    }


    public void addHuman(int id, String name, Gender gender, LocalDate birthDate) {

        Human human = new Human(id, name, gender, birthDate);
        tree.addHuman(human);

    }

    public void addParents(int id, int ids) {
            tree.addParentsHuman(id, ids);
    }

    public void addChildren(int id, int ids) {
            tree.addChildren(id, ids);
    }

    public void getSiblings(int id) {
            tree.getSiblingsHuman(id);
    }

    public void setDivorce(int id, int ids) {
            tree.setDivorceHuman(id, ids);
    }

    public void addSpouse(int id, int ids) {
            tree.addSpouseHuman(id, ids);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Human list:\n");

        for (Object human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }


}
