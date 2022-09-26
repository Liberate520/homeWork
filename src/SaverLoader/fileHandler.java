package SaverLoader;


import java.io.*;

public class fileHandler implements Writable{
    public boolean save(Serializable outstream, String path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(outstream);
            outputStream.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object load(String path) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return inputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setFilePath(String path) {

    }


//    @Override
//    public Object load(String filePath) {
//        FamilyTree familyTree = new FamilyTree();
//        return new FamilyTree() /*(new ObjectInputStream(filePath))*/;
//    }
}

