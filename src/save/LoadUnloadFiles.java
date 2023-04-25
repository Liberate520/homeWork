package save;

import tree.FamilyTree;

import java.io.*;

public class LoadUnloadFiles implements Writable {

    public FamilyTree read(String fileAddress)  {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
            FamilyTree tree = (FamilyTree) in.readObject();
            return tree;
        }
        catch (IOException | ClassNotFoundException e){
            return null;
        }
    }


    public boolean save(FamilyTree familyTree,String fileAddress)   {
        try {
            ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
            out.writeObject(familyTree);
            out.close();
            return true;
        }
        catch (IOException e){
            return false;
        }

    }

}
