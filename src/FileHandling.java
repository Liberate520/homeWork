package FileH;

import java.io.*;

public class FileHandling implements Serializable {
    private String text;

    FileHandling(String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return "File: " + text + ".";
    }

    public void WriteAndReadFile(FileHandling fileHandler, File f){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            oos.writeObject(fileHandler);
            FileHandling fh = (FileHandling) ois.readObject();
            System.out.println(fileHandler);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}