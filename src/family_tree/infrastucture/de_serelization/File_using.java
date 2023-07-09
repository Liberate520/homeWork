package family_tree.infrastucture.de_serelization;
import family_tree.tree.FamilyTree;
import java.io.*;

public class File_using implements My_Serialization{


    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object load(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            return ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
