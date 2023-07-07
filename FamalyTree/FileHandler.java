package homeWork.FamalyTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHandler implements SaveLoad{
    
    @Override
    public void Save(FamalyTree list, File file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
            oos.close();            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void LoadDate(FamalyTree list, File file){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            FamalyTree listRestored = (FamalyTree) ois.readObject();
            ois.close();
            System.out.println(listRestored);;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
