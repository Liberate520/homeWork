package Services;

import Human.Human;

import Presenter.Presenter;
import SaveLoad.SaveTxt;

import SaveLoad.Saveable;
import Tree.Comparators.humanComparatorByAge;
import Tree.Comparators.humanComparatorBySecondName;
import Tree.Comparators.humanComparatorBySex;
import ui.ConsoleUi;
import ui.View;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Service<E extends Human> implements Saveable {
    private List<E> relatives;




    public Service(List<E> relatives) {
        this.relatives = relatives;
    }
    public StringBuilder sortBySecondName(){
        System.out.println("сортировка дерева по фамилиям: ");
        relatives.sort(new humanComparatorBySecondName());
        return forEachToTree(relatives);

    }
    public StringBuilder sortBySex(){
        System.out.println("сортировка дерева по полу: ");
        relatives.sort(new humanComparatorBySex());
        return forEachToTree(relatives);
    }
    public StringBuilder sortByYear(){
        relatives.sort(new humanComparatorByAge());
        return forEachToTree(relatives);
        }
    public StringBuilder printTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве: ");
        sb.append(relatives.size());
        sb.append(" объектов: \n");
        int count=1;
        for (E human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getInfo());
            sb.append(" \n");
            count++;
        }
        return sb;

    }

    public void saveTree() throws IOException {
        SaveTxt data = new SaveTxt();
        data.save((Serializable) relatives);
    }
    public void loadTree() throws IOException, ClassNotFoundException {
        SaveTxt data = new SaveTxt();
        List treeRestored= (List) data.load();
        Service<E> service1 = new Service<>(treeRestored);
        View view = new ConsoleUi();
        new Presenter(view, service1);
        view.print("Загруженное дерево:");
        view.print(printTree().toString());


    }
    public StringBuilder forEachToTree(List<E> relatives){
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (E human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getFullName());
            sb.append(" \n");
            count++;
        }
        return sb;

    }

    @Override
    public void save(Serializable obj) throws IOException {

    }

    @Override
    public Serializable load() throws IOException, ClassNotFoundException {
        return null;
    }

}
