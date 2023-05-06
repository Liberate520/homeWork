package Services;

import Human.Human;
import SaveLoad.SaveDoc;
import SaveLoad.SaveTxt;
import SaveLoad.Saveable;
import Tree.Tree;
import java.io.IOException;

public class Service<E extends Human> {
    protected Tree<E> relatives;
    private Saveable saveable;

    public Service(Tree<E> relatives) {
        this.relatives = relatives;
        saveable = new SaveTxt();
    }

    public Service() {
        relatives = new Tree<E>();
    }

    public StringBuilder sortBySecondName() {
        relatives.sortBySecondName();
        return forEachToTree(relatives);
    }

    public StringBuilder sortBySex() {
        relatives.sortBySex();
        return forEachToTree(relatives);
    }

    public StringBuilder sortByYear() {
        relatives.sortByYear();
        return forEachToTree(relatives);
    }

    public StringBuilder printTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве: ");
        sb.append(relatives.getRelatives().size());
        sb.append(" объектов: \n");
        int count = 1;
        for (E human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getInfo());
            sb.append(" \n");
            count++;
        }
        return sb;
    }

    public boolean saveTree() throws IOException {
        if (saveable == null) {
            return false;
        }
        return saveable.save(relatives);
    }

    public boolean loadTree() throws IOException, ClassNotFoundException {
        if (saveable == null) {
            return false;
        }
        relatives = (Tree) saveable.load();
        return true;
    }



    public StringBuilder forEachToTree(Tree<E> relatives) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (E human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getFullName());
            sb.append(" \n");
            count++;
        }
        return sb;
    }

    public String addHuman(String birthDay, String firstName, String secondName, String patronymic, String sex) {
        Human human = new Human(birthDay, firstName, secondName, patronymic, sex);
        if (checkHuman((Tree<Human>) relatives, human)) {
            relatives.add((E) human);
            return "Человек успешно добавлен в дерево";
        } else {
            return "Такой человек уже есть в дереве";
        }
    }

    public boolean checkHuman(Tree<Human> relatives, Human human) {
        for (Human humanSearch : relatives) {
            if (human.equals(humanSearch)) {
                return false;
            }
        }
        return true;
    }
}
