import java.io.*;

public class LoadUnloadFiles implements FileProcessing {

    public FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree tree =  (FamilyTree)in.readObject();
        return tree;
    }


    public void save(FamilyTree familyTree,String fileAddress) throws IOException  {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(familyTree);
        out.close();
    }

}
