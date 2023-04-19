package model;

import java.io.*;

public class FileHandler implements WritableAndReadable {
    private String fileName;
    private String fileType;
    private static FileHandler fileHandler;

    public synchronized static FileHandler getFileHandler(String fileName, String fileType) {
        if (fileHandler == null){
            fileHandler = new FileHandler(fileName, fileType);
        }
        return fileHandler;
    }

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
