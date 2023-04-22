import java.io.*;

public class WriteAndRead implements SaveAndLoad, Serializable {
    
    @Override
    public void save(Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("homeWork/src/person.out"));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public void load() throws ClassNotFoundException {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("homeWork/src/person.out"));
            FamilyTree treeRestored = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(treeRestored);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
