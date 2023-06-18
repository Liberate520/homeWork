package tree.model.service;

import tree.model.geneticTree.Tree;
import tree.model.human.Gender;
import tree.model.human.Human;
import tree.model.saveLoad.Write;
import tree.view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {  //Класс Сервиса является непараметризированным
    private int id;
    private Tree<Human> geneticTree;
    private Write write;
    private View view;

    public Service(Tree<Human> geneticTree) {
        this.geneticTree = geneticTree;
        write = new Write();
    }

    public Service() {
        geneticTree = new Tree<>();
        write = new Write();
    }

    public boolean save() {
        return write.save((Serializable) geneticTree, write.getFILEPATH());
    }

    public void load(String filePath) {
        Object obj = write.load(filePath);
        if (obj instanceof Tree) {
            geneticTree = (Tree) obj;
        } else {
            view.print("Неправильный формат");
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

