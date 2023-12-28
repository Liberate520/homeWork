package model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.FamilyModel.*;
import model.HumanModel.*;

public class Service<T extends HumanInterface<T>> {

    public FamilyTree<T> familyTree;

    public Service(String filename) {
        this.LoadObject(filename);
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

    public void printAll() {
        for (T human : familyTree) {
            System.out.println(
                    human.getId() + " " + human.getFirstName() + " " + human.getLastName() + " " + human.getAge());
        }
    }

    public void printEntity(int id) {
        T human = this.findId(id);
        System.out.println(
                human.getId() + " " + human.getFirstName() + " " + human.getLastName() + " " + human.getAge());

    }

    public void setFather(int id1, int id2) {
        T human = this.findId(id1);
        T father = this.findId(id2);
        human.setFather(father);
    }

    public void setMother(int id1, int id2) {
        T human = this.findId(id1);
        T mother = this.findId(id2);
        human.setFather(mother);
    }

    public void findMather(T entity) {
        System.out.println("Мать:");
        T mather = familyTree.findMather(entity);

        if (mather != null) {
            HumanPrint<T> humanPrint = new HumanPrint<>(mather);
            this.printEntity((int) mather.getId());
        } else {
            System.out.println("Мать не найдена.");
        }
    }

    public void findFather(T entity) {
        System.out.println("Отец:");
        T father = familyTree.findFather(entity);

        if (father != null) {
            this.printEntity((int) father.getId());
        } else {
            System.out.println("Отец не найден.");
        }
    }

    public void addEntity(T entity) {
        this.familyTree.add(entity);
    }

    public T getID(int id) {
        return this.familyTree.getID(id);
    }

    public T findId(int id) {
        for (T h : this.familyTree) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    public void getParents(int id) {
        T entity = this.findId(id);
        T father = familyTree.findFather(entity);
        T mother = familyTree.findMather(entity);
        if (entity != null) {
            if (father != null) {
                System.out.println("Человек :");
                this.printEntity(id);
                System.out.println("Отец:");
                this.printEntity((int) father.getId());
            }
            if (mother != null) {
                System.out.println("Человек:");
                this.printEntity(id);
                System.out.println("Мать:");
                this.printEntity((int) mother.getId());
            }
        }
    }

    public void SaveObject(String filename) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this.familyTree);
            System.out.println("File has been written");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void LoadObject(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.familyTree = (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
