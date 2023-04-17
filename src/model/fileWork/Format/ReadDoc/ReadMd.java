package model.fileWork.Format.ReadDoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMd<T> implements interfaceRead<T>
{

    @Override
    public String read(T t) throws IOException, ClassNotFoundException 
    {
        FileReader fr = new FileReader("file.md");
        BufferedReader buff = new BufferedReader(fr);
        String str;
        System.out.println("\nВывод из файла формата .md\n ");
        StringBuilder sb = new StringBuilder();
            while((str = buff.readLine()) != null)
            {
                sb.append(str);
                System.out.println(str);
            }
        buff.close();
        System.out.println("Данные восстановлены! ");
        return sb.toString();
    }
    
}
