package ru.gb.Tree.Model.FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.gb.Tree.Model.Human.Human;
import ru.gb.Tree.Model.FamilyTree.Tree;


public class FileHandler implements Writable {
    private String filePath = "saveFile.out";


    public void saveFile(Tree<Human> tree){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(tree);
            System.out.println("Файл записан");
            oos.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public Tree<Human> readFile(){
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)))
        {
            return (Tree <Human>) ois.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Ошибка");
        } 
        return null;
    } 
}