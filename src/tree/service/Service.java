package tree.service;

import tree.geneticTree.Tree;
import tree.human.Gender;
import tree.human.Human;
import tree.saveLoad.Writable;
import tree.saveLoad.Write;
import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private int id;
//    private Tree geneticTree;
    Group<Human> geneticTree;
    private Writable writable;

    public Service(Group<Human> humans) {
        this.geneticTree = humans;
        writable = new Write();
    }

//    public Service() { // без понятия как сделать такой конструктор
//        this(new Tree<>());
//        writable = new Write();
//    }

    public boolean save(String filePath) {
        return writable.save((Serializable) geneticTree, filePath);
    }

    public void load(String filePath) {
        Object obj = writable.load(filePath);
        if (obj instanceof Tree) {
            geneticTree = (Tree) obj;
        } else {
            System.out.println("Неправильный формат");
        }
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        geneticTree.addHuman(new Human(id++, name, birthDate, gender, father, mother));
    }

    public void addHuman(String name, LocalDate yearOfBirth, Gender gender) { // конструктор без родителей/детей
        geneticTree.addHuman(new Human(id++, name, yearOfBirth, gender, null, null));
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (Human human : geneticTree) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        geneticTree.sortByName();
    }

    public void sortByAge() {
        geneticTree.sortByAge();
    }

    public Human getByName(String name) {
        return geneticTree.getByName(name);
    }
}

