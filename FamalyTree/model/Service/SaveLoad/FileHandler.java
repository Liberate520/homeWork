package homeWork.FamalyTree.model.Service.SaveLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import homeWork.FamalyTree.model.FamalysTree.FamalyTree;
import homeWork.FamalyTree.model.FamalysTree.ItemTree;


public class FileHandler<E extends ItemTree<E>> implements SaveLoad<E>{
    
    @Override
    public void Save(FamalyTree<E> list, File file){
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
    
    public FamalyTree<E> LoadData(FamalyTree<E> list, File file){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            FamalyTree<E> listRestored = (FamalyTree<E>) ois.readObject();
            ois.close();
            System.out.println(listRestored);
            return listRestored;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
        
    }
}
