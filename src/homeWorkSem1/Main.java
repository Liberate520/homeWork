package homeWorkSem1;
import homeWorkSem1.Service.ServiceComparator;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Human human1 = new Human("Irina", 68, Gender.Female, null, null);
        // Human human2 = new Human("Leonid", 69, Gender.Male, null, null);
        // Human human3 = new Human("Liudmila", 62, Gender.Female, null, null);
        // Human human4 = new Human("Alexander", 65, Gender.Male,null, null);
        // Human human5 = new Human("Kate", 36, Gender.Female, human2, human1);
        // Human human6 = new Human("Pavel", 37, Gender.Male, human4, human3);
        // Human human7 = new Human("Yaroslav", 7, Gender.Male, human6, human5);
        // Human human8 = new Human("Sviatoslav", 3, Gender.Male, human6, human5);
        int index=0;
        FamilyTree tree = new FamilyTree();
        
        Human human1 = new Human("Irina", 68, Gender.Female, null, null, index++);
        Human human2 = new Human("Leonid", 69, Gender.Male, null, null, index++);

        tree.createHuman("Liudmila", 62, Gender.Female, null, null);
        tree.createHuman("Alexander", 65, Gender.Male,null, null);
        tree.createHuman("Kate", 36, Gender.Female, human2, human1);

        System.out.println(tree); //список с id++
        
        ServiceComparator sc = new ServiceComparator();
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
