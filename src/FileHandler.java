import java.io.*;

public class FileHandler implements Writable, Serializable{

    @Override
    public void save(Object object) throws IOException {
        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.append(object.toString());
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.txt"));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @Override
    public Object read() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.txt"));
        Object read = objectInputStream.readObject();
        objectInputStream.close();
        return read;
    }
}
