import java.io.*;


public class FileHandler implements Writable{
    public boolean write(Serializable serializable, String filepath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filepath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath))){
            return objectInputStream.readObject();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
