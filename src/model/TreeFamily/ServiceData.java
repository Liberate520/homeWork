package model.TreeFamily;

import model.Datatable;

import java.io.*;

public class ServiceData implements Datatable {
//    @Override
//    public void save(Object object) throws IOException {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.out"));
//        objectOutputStream.writeObject(object);
//        objectOutputStream.close();
//    }
//
//    @Override
//    public Object read() throws ClassNotFoundException, IOException {
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.out"));
//        Object read = objectInputStream.readObject();
//        objectInputStream.close();
//        return read;
//    }
    @Override
    public void save(Object object){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.out"));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
    }}


        @Override
        public Object read()  {
        try {ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.out"));
            Object read = objectInputStream.readObject();

            return read;
            //objectInputStream.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }


        }
}
