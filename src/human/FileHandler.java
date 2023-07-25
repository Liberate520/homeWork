package human;


import java.io.*;

public class FileHandler implements Writable{
    @Override
    public Serializable readFile(String path) {
        try (FileInputStream file = new FileInputStream(path)) {
            ObjectInputStream oins = new ObjectInputStream(file);

            // Method for deserialization of object
            Serializable object = (Serializable) oins.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void saveFile(Serializable serial) {
        try(FileOutputStream fos = new FileOutputStream("familytree.out")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(serial);
            oos.flush();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
