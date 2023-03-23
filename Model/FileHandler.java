package Model;

import java.io.Serializable;

import Model.GenealogicalTree.Animal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler<T extends Animal> implements Writable<T>, Serializable {
    private String fileName;
    private static final long serialVersionUID = 1;

    public FileHandler() {
        this.fileName = "GenealogicalTree.out";
    }

    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Сериализация в файл с помощью класса ObjectOutputStream
     */
    @Override
    public String save(Serializable serializable) {
        StringBuilder sb = new StringBuilder();
        sb.append("Сохраняем...\n");
        try {
            FileOutputStream outStream = new FileOutputStream(fileName, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
            objectOutputStream.writeObject(serializable);
            outStream.close();
            objectOutputStream.close();
            sb.append("Cохранено в файл ");
            sb.append(fileName);
            sb.append("\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            sb.append("Ошибка\n");
        }
        return sb.toString();
    }
    /**
     * // Востановление из файла с помощью класса ObjectInputStream
     */
    @Override
    public Serializable read() {
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inStream);
            Serializable tempTree = (Serializable) objectInputStream.readObject();
            inStream.close();
            objectInputStream.close();
            return tempTree;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
