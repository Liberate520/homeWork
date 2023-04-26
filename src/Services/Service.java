package Services;

import Human.Human;
import SaveLoad.SaveTxt;

import Tree.Comparators.humanComparatorByAge;
import Tree.Comparators.humanComparatorBySecondName;
import Tree.Comparators.humanComparatorBySex;
import Tree.Tree;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Service<E extends Human> {
    private List<E> relatives;


    public Service(List<E> relatives) {
        this.relatives = relatives;
    }
    public void sortBySecondName(){
        System.out.println("сортировка дерева по фамилиям: ");
        relatives.sort(new humanComparatorBySecondName());
        for (E human: relatives) {
            System.out.println(human.getFullName());
        }

    }
    public void sortBySex(){
        System.out.println("сортировка дерева по полу: ");
        relatives.sort(new humanComparatorBySex());
        for (E human: relatives) {
            System.out.println(human.getFullName());
        }
    }
    public void sortByYear(){
        relatives.sort(new humanComparatorByAge());
        for (E human: relatives) {
            System.out.println(human.getFullName());
        }
        }
    public void  printTree() {
        System.out.println("распечатать дерево:");
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве: ");
        sb.append(relatives.size());
        sb.append(" объектов: \n");
        int count=1;
        for (Human human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getInfo());
            sb.append(" \n");
            count++;
        }
        System.out.println(sb);
    }

    public void saveTree() throws IOException {
        SaveTxt data = new SaveTxt();
        data.save((Serializable) relatives);
    }
    public void loadTree() throws IOException, ClassNotFoundException {
        System.out.println("Загрузка дерева из файла: ");
        SaveTxt data = new SaveTxt();
        List treeRestored= (List) data.load();

    }

}
