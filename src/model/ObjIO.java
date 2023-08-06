package src.model;

//import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjIO implements FileReadWrite {

    @Override
    public Serializable readFile(String aFileName) {   // throws IOException, ClassNotFoundException {
        Serializable aObj = null;
        // Востановление из файла с помощью класса ObjectInputStream

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(aFileName))) {
            aObj = (Serializable) objectInputStream.readObject();
//            System.out.println("Загрузка данных: успех !\nВаше семейное древо загружено !");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
//        ObjectInputStream objectInputStream = new ObjectInputStream(
//                new FileInputStream(aFileName));
//        aObj = (Serializable) objectInputStream.readObject();
//        objectInputStream.close();
        return aObj;
    }
    

    @Override
	public String writeFile(String aFileName, Serializable aObj){  // throws IOException, ClassNotFoundException
	    //Сериализация в файл с помощью класса ObjectOutputStream
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                new FileOutputStream(aFileName));
//        objectOutputStream.writeObject(aObj);
//        objectOutputStream.close();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(aFileName))) {
            objectOutputStream.writeObject(aObj);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }


        return aFileName;
	}
}

