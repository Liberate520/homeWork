package Homework.Tree;

import Homework.Human.Human;

import java.io.*;

public class FileMethods extends FamilyTree implements Writable, Serializable {

    public static void saveInFile(Human human, String filePath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath));
        objectOutputStream.writeObject(human);
        objectOutputStream.close();
    }

    public static void readOutFile(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath));
        Human humanRestored = (Human) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(humanRestored);
    }


    @Override
    public boolean saveAllInFile(Serializable serializable, String filePath) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));){
           objectOutputStream.writeObject(serializable);
           return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO отдельный метод по доставанию из файла информации об одном человеке

}
