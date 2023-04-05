import java.io.*;

public class DataRepository implements Serializable, Repository {

    public void dataOutput(FamilyTree familyTree, Person person) {

        File file = new File("D:\\GB\\JavaOOPFamilyTree\\" +
                "homeWork_From_Salnikov_Vladislav\\src\\Data\\Family.txt");

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos!=null){
                oos = new ObjectOutputStream(fos);
                oos.writeObject(familyTree);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FamilyTree deserialization(){
        File file = new File("D:\\GB\\JavaOOPFamilyTree\\" +
                "homeWork_From_Salnikov_Vladislav\\src\\Family.txt");
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis!= null){
                ois = new ObjectInputStream(fis);
                FamilyTree familyTree = (FamilyTree) ois.readObject();
                return familyTree;
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new FamilyTree();
    }
}
