package model.service;

import java.util.List;

import model.FamilyModel.*;
import model.HumanModel.*;

public class Service<T extends HumanInterface<T>> {

    public FamilyTree<T> familyTree;

    public Service(String filename) {
        this.familyTree = FamilyTreeGUI.LoadObject(filename);
    }

    public Service(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public void add(T entity) {
        familyTree.add(entity);
    }

    public void PrintAll() {
        FamilyTreeGUI.PrintAll(familyTree);
    }

    public void findMather(T entity) {
        System.out.println("Мать:");
        T mather = familyTree.findMather(entity);

        if (mather != null) {
            HumanPrint<T> humanPrint = new HumanPrint<>(mather);
            humanPrint.printHumanFLA(mather);
        } else {
            System.out.println("Мать не найдена.");
        }
    }

    public void findFather(T entity) {
        System.out.println("Отец:");
        T father = familyTree.findFather(entity);

        if (father != null) {
            HumanPrint<T> humanPrint = new HumanPrint<>(father);
            humanPrint.printHumanFLA(father);
        } else {
            System.out.println("Отец не найден.");
        }
    }

    public void findChildren(T entity) {
        System.out.println("Дети:");
        List<T> children = familyTree.findChildren(entity);
        if (children.size() != 0) {
            HumanPrint<T> humanPrint = new HumanPrint<>(entity);
            humanPrint.printHumanFLAList(children);
        } else {
            System.out.println("Дети не найдены.");
        }
    }

    public void addEntity(T entity) {
        this.familyTree.add(entity);
    }

    public void SaveInFile(String filename) {
        FamilyTreeGUI f = new FamilyTreeGUI();
        f.SaveObject(filename, this.familyTree);
    }

    public void LoadFile(String filename) {
        // FamilyTreeGUI f = new FamilyTreeGUI();
        this.familyTree = FamilyTreeGUI.LoadObject(filename);
    }

    public T getID(int id) {
        return this.familyTree.getID(id);
    }

    public void GetParrents(int id) {
        FamilyTreeGUI.getParents(this.familyTree, getID(id));
    }
}
