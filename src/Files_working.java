import java.io.*;
import java.util.List;


public class Files_working implements Serializable, File_interface {


    @Override
    public List<Human> read_files() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("backup"));
        return (List<Human>) in.readObject();
    }

    @Override
    public void write_files(List<Human> fos) throws IOException {

        try {
            FileOutputStream out = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(fos);
            oos.close();
            System.out.println("Human List serialized");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

