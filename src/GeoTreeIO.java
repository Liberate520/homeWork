import java.io.*;

public class GeoTreeIO implements write, read, Serializable{
    public void write(GeoTree geo) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("geo.txt"));
        objectOutputStream.writeObject(geo);
        System.out.println(geo);
        objectOutputStream.close();
    }

    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("geo.txt"));
        System.out.println((GeoTree) objectInputStream.readObject());
        objectInputStream.close();
    }

}
