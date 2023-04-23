package Package.WorkWithFiles;

import java.io.*;

public class Files implements Filable, Serializable {
    private ObjectOutputStream output;
    public Files(){}

    @Override
    public void writeObj(Object obj, String name) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(name));
        output.writeObject(obj);
        output.close();
    }

    @Override
    public void readObj(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(name));
        Object obj = (Object) input.readObject();
        input.close();
    }
}
