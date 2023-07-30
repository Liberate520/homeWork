package genealogy_tree.service;

import genealogy_tree.Human.Gender;
import genealogy_tree.Human.Human;
import genealogy_tree.Tree.GeneologiTree;
import genealogy_tree.WriterAndReader.FileHandler;

import java.time.LocalDate;


public class Service {
    private GeneologiTree tree;
    private int id;
    private FileHandler fileHandler;

    public Service() {
        tree = new GeneologiTree();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(id++, name, gender, birthDate);
        tree.addHuman(human);
        tree.setWedding(human, human);
        tree.setDivorce(human, human);
        human.addParents(human);
        human.addChild(human);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Human list:\n");

        for (Human human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }
}
