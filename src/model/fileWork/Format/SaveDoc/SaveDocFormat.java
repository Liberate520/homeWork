package model.fileWork.Format.SaveDoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDocFormat<T> implements InterfaceSave<T>
{

    @Override
    public void write(T t) throws IOException, ClassNotFoundException
     {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.doc");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("<? Doc Format>\n");
            writer.write(t.toString()); 
            writer.flush();    
    }
    
}
