package Services;

import Human.Human;
import SaveLoad.SaveTxt;
import Tree.Tree;

import java.io.IOException;

public class Service<E extends Human> {
    protected Tree<E> relatives;
    protected SaveTxt data;

    public Service(Tree<E> relatives) {
        this.relatives = relatives;
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
        SaveTxt data = new SaveTxt();
        if (data == null) {
            return false;
        }
        return data.save(relatives);
    }

    public boolean loadTree() throws IOException, ClassNotFoundException {
        SaveTxt data = new SaveTxt();
        if (data == null) {
            return false;
        }
        relatives = (Tree) data.load();
        return true;
    }

    public void setData(SaveTxt data) {
        new SaveTxt();
        this.data = data;
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
