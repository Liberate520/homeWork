package ru.gb.Tree.Model.FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.gb.Tree.Model.Human.Human;
import ru.gb.Tree.Model.FamilyTree.Tree;


public class FileHandler implements Writable {

    public void saveFile(Tree<Human> tree, String path){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(tree);
            System.out.println("Файл записан");
            oos.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public Tree<Human> readFile(String path){
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            return (Tree <Human>) ois.readObject(); // спросить на семинаре
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
        return null;
    } 
}