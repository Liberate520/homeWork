package homeWorkSem1;

import java.io.IOException;

import homeWorkSem1.Service.Gender;
import homeWorkSem1.Service.Service;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int index=0;
        FamilyTree<Human> tree = new FamilyTree<>();
        
        Human human1 = new Human("Irina", 68, Gender.Female, null, null, index++);
        Human human2 = new Human("Leonid", 69, Gender.Male, null, null, index++);
        Human human3 = new Human("Liudmila", 62, Gender.Female, null, null, index++);
        Human human4 = new Human("Alexander", 65, Gender.Male,null, null, index++);
        Human human5 = new Human("Kate", 36, Gender.Female, human2, human1, index++);

        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        System.out.println(tree); //список с id++
        
        Service<Human> sc = new Service<>();
        sc.sortbyName1(tree);// сортировка по имени
        System.out.println(tree);//вывели отсортированный список по имени

        sc.sortById(tree);//сортировка по id
        System.out.println(tree);

        sc.sortByAge(tree); //сортировка по age
        System.out.println(tree);

        System.out.println("_-_-_");
        for (Human human : tree) { //итерируем список
            System.out.println(human);
        }
    }
}
