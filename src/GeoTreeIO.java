import java.io.*;

public class GeoTreeIO implements write, read, Serializable{
    public void write(Serializable geo) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("geo.txt"));
        objectOutputStream.writeObject(geo);
        System.out.println(geo);
        objectOutputStream.close();
    }

    public GeoTree read(Serializable geo) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("geo.txt"));
        GeoTree geoRestored = (GeoTree) objectInputStream.readObject();
        objectInputStream.close();
        return geoRestored;
    }
}
