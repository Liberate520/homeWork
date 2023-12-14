package family_tree.model.file_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import family_tree.model.file_system.enums.StatusFileFS;

public class OOS implements Writable
{
    public StatusFileFS Save(Serializable serializable, String file_path)
    {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_path)))
        {
            oos.writeObject(serializable);
            return StatusFileFS.FileSaved;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return StatusFileFS.FileNotSaved;
        } 
    }

    // public <T> TreeItem<T> Read(String file_path)
    // {
    //     // Востановление из файла с помощью класса ObjectInputStream
    //     try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_path)))
    //     {
    //         return (TreeItem) ois.readObject();
    //     }
    //     catch(Exception ex){     
    //         ex.printStackTrace();
    //         return null;
    //     } 
    // }

    public Object Read(String file_path)
    {
        // Востановление из файла с помощью класса ObjectInputStream
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_path)))
        {
            return ois.readObject();
        }
        catch(Exception ex){     
            ex.printStackTrace();
            return null;
        } 
    }
}
