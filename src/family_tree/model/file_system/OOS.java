package family_tree.model.file_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class OOS implements Writable
{
    public void Save(Serializable serializable, String file_path)
    {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_path)))
        {
            oos.writeObject(serializable);
            System.out.println("File has been written");
        }
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }

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
