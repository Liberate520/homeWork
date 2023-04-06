import java.io.*;
public class Data implements Writeable{
    @Override
    public void save(Object o) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
    @Override
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.txt"));
        Object ob = (Object) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(ob);
    }
}
