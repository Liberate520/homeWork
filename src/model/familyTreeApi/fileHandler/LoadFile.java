package model.familyTreeApi.fileHandler;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.familyTreeApi.FamilyTree;
import model.familyTreeApi.Human;

public class LoadFile implements WriterReader {
    @Override
    @SuppressWarnings("unchecked")
    public FamilyTree<Human> read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree<Human> readObject = (FamilyTree<Human>)in.readObject();
        FamilyTree<Human> tree =  readObject;
        in.close();
        return tree;
    }

    @Override
    public void save(FamilyTree<Human> tree, String fileAddress) throws IOException {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(tree);
        out.close();
    }
}
