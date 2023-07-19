package faminly_tree.model.save_in_file;

import faminly_tree.model.human.Human;
import faminly_tree.model.tree.FamiliItem;
import faminly_tree.model.tree.FamilyTree;

import java.io.*;

public class SaveInFile implements WriteAndRead {

    @Override
    public void write(String path, Human human) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(human);
        objectOutputStream.close();
    }

    @Override
    public void write(String path, FamilyTree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    @Override
    public Human readHuman(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Human human = (Human) objectInputStream.readObject();
        objectInputStream.close();
        return human;
    }

    @Override
    public FamilyTree readTree(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}