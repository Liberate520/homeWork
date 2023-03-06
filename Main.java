import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human aivaz = new Human("Айваз", "Male", 1, 4, 1988);
        Human anzhela = new Human("Анжела", "Female", 7, 9, 1990);
        Human shamil = new Human("Шамиль", "Male", 5, 2, 1956);
        Human olga = new Human("Ольга", "Female", 10, 12, 1960);
        Human gaian = new Human("Гаян", "Male", 1, 4, 2020);
        aivaz.addParents(shamil, olga);
        gaian.addParents(aivaz, anzhela);
        GenealogicalTree gareevTree = new GenealogicalTree();
        gareevTree.addMember(shamil);
        gareevTree.addMember(olga); 
        gareevTree.addMember(aivaz);
        gareevTree.addMember(anzhela);
        gareevTree.addMember(gaian);
        aivaz.printMember();
                
        //Сериализация в файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.out"));
        objectOutputStream.writeObject(gareevTree);
        objectOutputStream.close();
        gareevTree.save();
        
        //Восстановление из файла
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("tree.out"));
        GenealogicalTree myTree = (GenealogicalTree) objectInputStream.readObject();
        objectInputStream.close();
        

    }
}
