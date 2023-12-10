package model.FamilyModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.FamilyModel.*;
import model.HumanModel.*;

public class FamilyTreeGUI {

    public static <T extends HumanInterface<T>> void getChildren(FamilyTree<T> familyTree, T entity) {
        List<T> children = familyTree.findChildren(entity);
        System.out.println("This Human:");
        HumanPrint.printHumanFLA(entity.getSelf());
        System.out.println("Has children:");
        // HumanPrint.printHumanFLAList(children);
        for (T h : children) {
            HumanPrint.printHumanFLA(h.getSelf());
        }
    }

    public static <T extends HumanInterface<T>> void getParents(FamilyTree<T> familyTree, T entity) {
        T father = familyTree.findFather(entity);
        T mother = familyTree.findMather(entity);
        if (father != null) {
            System.out.println("This Human:");
            HumanPrint.printHumanFLA(entity.getSelf());
            System.out.println("Has father:");
            HumanPrint.printHumanFLA(father.getSelf());
        }
        if (mother != null) {
            System.out.println("This Human:");
            HumanPrint.printHumanFLA(entity.getSelf());
            System.out.println("Has mother:");
            HumanPrint.printHumanFLA(mother.getSelf());
        }
    }

    public static void SaveObject(String filename, FamilyTree familyTree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
            System.out.println("File has been written");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public static FamilyTree LoadObject(String filename) {
        FamilyTree tmp = new FamilyTree<>();
        try (FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            tmp = (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    public static void PrintAll(FamilyTree familyTree) {
        HumanPrint.printHumanFLAList(familyTree.getHumanList());
    }

}