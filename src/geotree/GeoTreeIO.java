package geotree;

import java.io.*;

public class GeoTreeIO implements Writable, Readable, Serializable{
    public void write(GeoTree geo) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("geo.txt"));
        objectOutputStream.writeObject(geo);
        System.out.println(geo);
        objectOutputStream.close();
    }

    public GeoTree read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("geo.txt"));
        Object result = objectInputStream.readObject();
        if (result instanceof GeoTree){
            GeoTree result2 = (GeoTree) result;
            System.out.println(result2);
            return result2;
        }
        return null;
    }

}
