package FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHolder implements Writable {
    @Override
    public void save(FamilyTree tree) { //не понимаю как это работает, тупо скопировал, засунул в try with resources и все.
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("database.txt"))) {
            objectOutputStream.writeObject(tree);
        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }

    @Override
    public FamilyTree read() { //не понял как эти потоки работают, мы такое не проходили. Надеюсь на третьем семинаре разобрали. Там буду смотреть.
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("database.txt"))) {
            FamilyTree tree = (FamilyTree) objectInputStream.readObject();
            return tree; //возвращать в 26 строчке не хочет.
        }catch (Exception e){
            System.out.println("Error" +e);
        }
        return null;
    }


}
