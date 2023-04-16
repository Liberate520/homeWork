package Model.Save;

import Model.FamilyTree.FamilyTree;

import java.io.*;
public class DataLoad implements FileProcessing {
    @Override
    public FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree tree =  (FamilyTree)in.readObject();
        in.close();
        return tree;
    }
    @Override
    public void save(FamilyTree tree, String fileAddress) throws IOException {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(tree);
        out.close();
    }
}
