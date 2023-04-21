package model.save;

import java.io.IOException;

public interface Writable {
    
   public void  save(Object T, String fileName)throws IOException;

   public Object read(String fileName)throws IOException, ClassNotFoundException;
}
