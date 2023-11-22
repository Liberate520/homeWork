package family_tree.model.base;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FileHandlerForTree {
    public static void HandlerForTree(){
        String filePath = "homeWork/src/model_app/family_tree.txt";
        // выводим на экран
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Десериализуем объекты
            while (true) {
                try {
                    Human human;
                    human = (Human) objectInputStream.readObject();
                    System.out.println(human);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }






    }

}
