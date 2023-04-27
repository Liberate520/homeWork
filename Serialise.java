import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialise  implements Serialisible {

    @Override
    public void Serialise(String filename, Object o) throws FileNotFoundException, IOException {
        ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(filename));
        oOS.writeObject(o);
        oOS.close();
    }

    @Override
    public  Object Out(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(filename));
        Object o = (Object) oIS.readObject();
        oIS.close();
        return o;
        
    }

    @Override
    public void SerialiseList(String filename, ArrayList<Object> list) throws FileNotFoundException, IOException {
        ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(filename));
        for (Object o : list){
            oOS.writeObject(o);
        }
        oOS.close();
        
    }

    @Override
    public ArrayList<Object> OutList(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(filename));
        ArrayList<Object> list = new ArrayList<>();
        Object o = (Object) oIS.readObject();
        while(o != null){
            list.add(o);
            o = (Object) oIS.readObject();
        }
        return null;
    }

    
    
}