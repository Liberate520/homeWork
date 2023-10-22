package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class FileHandler implements Writable {
    private String fileName;
    private String fileType;

    public FileHandler(String fileName, String fileType){
        this.fileName = fileName;
        this.fileType = fileType;
    }

    String getFileName() {
        return fileName;
    }

    String getFileType() {
        return fileType;
    }

    @Override
    public void writeTreeInFile(FamilyTree object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName + "." + fileType));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(fileName + "." + fileType));
        FamilyTree object = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }
}