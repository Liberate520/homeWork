import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


public class ObjIO implements FileReadWrite{

    @Override
    public Serializable readFile(String aFileName) throws IOException, ClassNotFoundException {  
        Serializable aObj = null;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName));
        aObj = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        return aObj;
    }
    

    @Override
	public String writeFile(String aFileName, Serializable aObj) throws IOException  {  // , ClassNotFoundException
	    //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(aFileName));
        objectOutputStream.writeObject(aObj);
        objectOutputStream.close();
        return aFileName;
	}
}


