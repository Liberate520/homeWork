package tree.model.service;

import tree.model.geneticTree.Tree;
import tree.model.human.Gender;
import tree.model.human.Human;
import tree.model.saveLoad.Writable;
import tree.model.saveLoad.Write;
import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {  //Класс Сервиса является непараметризированным
    private int id;
    private Tree<Human> geneticTree;
//    Group<Human> geneticTree;
    private Writable writable;

    public Service(Tree<Human> geneticTree) {
        this.geneticTree = geneticTree;
        writable = new Write();
    }

    public Service() {
        geneticTree = new Tree<>();
        writable = new Write();
    }

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

