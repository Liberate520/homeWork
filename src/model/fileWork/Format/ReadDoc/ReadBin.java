package model.fileWork.Format.ReadDoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadBin<T> implements interfaceRead<T>
{

    @Override
    public String read(T t) throws IOException, ClassNotFoundException 
    {
        FileInputStream fis = new FileInputStream("text.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        T t1 = (T) ois.readObject();
        ois.close();
        System.out.println("Файл восстановлен : " + t1);
        return t1.toString();
    }
    
}