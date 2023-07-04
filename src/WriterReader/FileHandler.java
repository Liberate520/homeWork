package WriterReader;

import java.io.*;

public class FileHandler implements Serializable {
    private String text;

    FileHandler(String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return "File: " + text + ".";
    }

    public void WriteAndReadFile(FileHandler fileHandler, File f){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            oos.writeObject(fileHandler);
            FileHandler fh = (FileHandler) ois.readObject();
            System.out.println(fileHandler);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
