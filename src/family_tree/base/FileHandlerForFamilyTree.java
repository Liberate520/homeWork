package family_tree.base;

import family_tree.human.Human;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileHandlerForFamilyTree {
    public static <E> void main(String[] args) {
        String filePath = "homeWork/src/family_tree.txt";
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Десериализуем
            Human human1 = (Human) objectInputStream.readObject();
            Human human2 = (Human) objectInputStream.readObject();
            Human human3 = (Human) objectInputStream.readObject();
            Human human4 = (Human) objectInputStream.readObject();
            Human human5 = (Human) objectInputStream.readObject();
            Human human6 = (Human) objectInputStream.readObject();
            Human human7 = (Human) objectInputStream.readObject();
            Human human8 = (Human) objectInputStream.readObject();
            Human human9 = (Human) objectInputStream.readObject();

            // выводим на экран
            System.out.println("===============================");
            System.out.println("Фамильное Дерево : ");
            System.out.println(human1);
            System.out.println(human2);
            System.out.println(human3);
            System.out.println(human4);
            System.out.println(human5);
            System.out.println(human6);
            System.out.println(human7);
            System.out.println(human8);
            System.out.println(human9);
            System.out.println("                    FAMILY TREE");
            System.out.println("===============================");

        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
