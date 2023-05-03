package Package.Model.WorkWithFiles;

import java.io.*;

public class Files implements Writable, Readable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    public Files(String name) throws IOException {
        this.output = new ObjectOutputStream(new FileOutputStream(name));
        this.input = new ObjectInputStream(new FileInputStream(name));
    }

    @Override
    public void writeObj(Object obj) throws IOException {
        try {
            output.writeObject(obj);
            output.close();
        }
        catch (Exception ex){
            System.out.println("Не получилось сериализовать объект...");;
        }
    }

    @Override
    public void readObj() throws IOException, ClassNotFoundException {
        try {
            Object obj = (Object) input.readObject();
            input.close();
        }
        catch (Exception ex){
            System.out.println("Не получилось десериализовать объект...");;
        }
    }
}
