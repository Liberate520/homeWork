package FileWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import FamalyTree.FamalyTree;

public class Filehundler implements Writeble{
    /**
     * Метод сохранение дерева в файл
     */
    public void SaveInFile(FamalyTree o){
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("tree.out"));
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    /**
     * Метод загрузки дерева из файла
     */
    public Object LoadInFile(){
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("tree.out"));
        Person igorRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();

        return Object;

    }
}
