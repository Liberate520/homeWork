import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("family.txt"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        System.out.println("Сохранено");
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("family.txt"));
        FamilyTree family = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return family;
    }
}
