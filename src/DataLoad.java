import java.io.*;
public class DataLoad implements FileProcessing {
    @Override
    public void read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree tree =  (FamilyTree)in.readObject();
        System.out.println(tree);
        in.close();
    }

    @Override
    public void save(FamilyTree tree, String fileAddress) throws IOException {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(tree);
        out.close();
    }

}
