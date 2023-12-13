package model.writer;

import model.tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    private String filepath;
    @Override
    public boolean save(Serializable serializable, String filePath) {
        boolean flag = false;

        File file = new File(filepath);
        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(file)){
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(serializable);
                flag = true;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public Object read(String filePath) throws InvalidObjectException {
        File file = new File(filepath);
        ObjectInputStream ois = null;
        try (FileInputStream fis = new FileInputStream(file)){
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                FamilyTree readFamily = (FamilyTree) ois.readObject();
                return readFamily;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        throw new InvalidObjectException("Что-то пошло не так...");
    }

}