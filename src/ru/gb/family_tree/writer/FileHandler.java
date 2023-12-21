package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writable {
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public boolean writeObject(Object o, String fileName) {


        {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
                objectOutputStream.writeObject(o);
                return true;

            } catch (IOException ignored) {
                return false;
            }

        }
    }

    public Object readObject(String fileName) {
        {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
                return objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean close() {
        try {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }
}




//import java.io.Serializable;
//import java.io.*;
//
//public class FileHandler implements Writeble{
//
//
//        public boolean save(Serializable serializable, String path){
//            try{
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
//                objectOutputStream.writeObject(serializable);
//                //objectOutputStream.close();
//                System.out.println("Family tree saved");
//                return true;
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//                return false;
//            }
//        }
//
//        public Object read(String path){
//            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path)))
//            {
//                System.out.println("Family tree loaded");
//                return objectInputStream.readObject();
//                //objectInputStream.close();
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//}
