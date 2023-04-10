package file;
import java.io.*;

import tree1.FamilyTree;


public class DataSave implements FileProcess{
    @Override
    public FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree familyTree1 =  (FamilyTree)in.readObject();
        //System.out.println(familyTree1);
        in.close();
        return familyTree1;
    }

    @Override
    public void save(FamilyTree familyTree1, String fileAddress) throws IOException {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(familyTree1);
        out.close();
    }
}
