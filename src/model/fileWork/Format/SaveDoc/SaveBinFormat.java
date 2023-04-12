package model.fileWork.Format.SaveDoc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveBinFormat<T> implements InterfaceSave<T> 
{

    @Override
    public void write(T t) throws IOException, ClassNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("text.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            fos.close();
    }
    
}
