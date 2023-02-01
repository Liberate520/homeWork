package writables;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHandler<T> implements Writable<T> {

    private static final String FILE_NAME = "src/sss.txt";

    @Override
    public void save(List<T> list){
         FileOutputStream fos;
         ObjectOutputStream objOutputStream;
        try {
            fos = new FileOutputStream(FILE_NAME);
            objOutputStream = new ObjectOutputStream(fos);
            for (T obj : list) {
                objOutputStream.writeObject(obj);
                objOutputStream.reset();
            }
            objOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> read() {
        List<T> list = new ArrayList<>();
        FileInputStream fis;
        
        try {
            fis = new FileInputStream(FILE_NAME);
            try (ObjectInputStream obj = new ObjectInputStream(fis)) {
                try {
                    while (fis.available() != -1) {
                        list.add((T) obj.readObject());
                    }
                } catch (EOFException ex) {
                    //ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
  
        return list;
    }
}
