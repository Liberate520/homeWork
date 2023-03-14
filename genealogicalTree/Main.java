package genealogicalTree;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import package1.*;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Human aivaz = new Human("Айваз", "Male", 1, 5, 1988);
        Human anzhela = new Human("Анжела", "Female", 7, 10, 1990);
        Human shamil = new Human("Шамиль", "Male", 5, 3, 1956);
        Human olga = new Human("Ольга", "Female", 10, 13, 1960);
        Human gaian = new Human("Гаян", "Male", 1, 5, 2020);
        aivaz.addParents(shamil, olga);
        gaian.addParents(aivaz, anzhela);
        GenealogicalTree<Human> gareevTree = new GenealogicalTree<Human>();
        gareevTree.addMember(shamil);
        gareevTree.addMember(olga); 
        gareevTree.addMember(aivaz);
        gareevTree.addMember(anzhela);
        gareevTree.addMember(gaian);
        aivaz.printMember();
              
        // gareevTree.setFileHandler(new FileHandler(gareevTree));
        // gareevTree.save();
        
        //Сериализация в файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("tree.out"));
        objectOutputStream.writeObject(gareevTree);
        objectOutputStream.close();

        //Восстановление из файла
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("tree.out"));
        GenealogicalTree myTree = (GenealogicalTree) objectInputStream.readObject();
        objectInputStream.close();

        Human findMember = myTree.searchName("Гаян");
        findMember.printMember();
        
        for (Human member : gareevTree) {
            member.printMember();
        }

        gareevTree.printTree();
        gareevTree.sortByName();
        gareevTree.printTree();
        gareevTree.sortByYear();
        gareevTree.printTree();
    }
}
