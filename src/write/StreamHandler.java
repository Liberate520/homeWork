package write;

import familytree.FamilyTree;

import java.io.*;

public class StreamHandler implements Writable, Serializable {

    private String fileName = "";
    private String fileExtension = ".ser";
    private int fileType = 1;
    private String fileTypeDescription = "binary file";


    @Override
    public void defineFileName(String fileName) {
        this.fileName = fileName + fileExtension;
    }

    @Override
    public String fileName() {
        return fileName;
    }

    @Override
    public int fileType() { return fileType;}

    @Override
    public String fileTypeDescription() { return fileTypeDescription; }

    @Override
    public void save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public FamilyTree load() {
        FamilyTree result = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileName));
            result = (FamilyTree)objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
