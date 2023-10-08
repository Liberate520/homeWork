package FamilyTree.writer;

import java.io.*;

public class FileHandler implements Writable{

public void write (Serializable serializable, String filePath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

        public Object read(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        //objectInputStream.close();
        return objectInputStream.readObject();
    }
}

//

//    public boolean write(Serializable serializable, String filePath) {
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            objectOutputStream.writeObject(serializable);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

//    public Object read(String filePath) {
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
//            return objectInputStream.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }



