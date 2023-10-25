package family_tree.file_system;

import java.io.*;

import family_tree.family_trees.FamilyTree;

public class FS implements Writable{

    public void save(Serializable serializable, String file_path)
    {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_path)))
        {
            oos.writeObject(serializable);
            System.out.println("File has been written");
        }
        catch(Exception ex){
                
            // System.out.println(ex.getMessage() + " - это ошибка");
            ex.printStackTrace();
        } 
    }

    public Object read(String file_path)
    {
        // Востановление из файла с помощью класса ObjectInputStream
       // Object treeRestored = new Object();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_path)))
        {
            return ois.readObject();
        }
        catch(Exception ex){     
            //System.out.println(ex.getMessage() + " - это ошибка");
            ex.printStackTrace();
            return null;
        } 

       // return treeRestored;
    }

    public boolean fileExist(String file_path)
    {
        File file = new File(file_path);
        if(file.exists())
        {
            return true;
        }
        return false;
    }
    
}
