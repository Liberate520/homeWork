package hwSeminar1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Irina", 71, false, null, null);
        Human human2 = new Human("Leonid", 69, true, null, null);
        Human human3 = new Human("Liudmila", 62, false, null, null);
        Human human4 = new Human("Alexander", 65, true,null, null);
        Human human5 = new Human("Kate", 36, false, human2, human1);
        Human human6 = new Human("Pavel", 37, true, human4, human3);
        Human human7 = new Human("Yaroslav", 7, true, human6, human5);
        Human human8 = new Human("Sviatoslav", 3, true, human6, human5);

        FamilyTree tree = new FamilyTree();
        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);
        tree.add(human8);
        System.out.println(tree);
        System.out.println("--------");
        
        System.out.printf(" Объект - %s \n Мать Объекта -  %s Отец Объекта - %s", human7.getName(), human7.getMother(), human7.getFather());
        System.out.println("--------");
        
        System.out.printf("Дети Объекта: %s\n", human5.getChildren());
        System.out.println("--------");
        
        List<Human> findSisBro = human7.getSisBro();
        System.out.printf("Братья/сестры Объекта \n %s", findSisBro);
        System.out.println("--------");
        
        List<Human> grands = human8.getGrands();
        System.out.printf("Бабушки/дедушки Объекта: \n%s", grands);
        System.out.println();
        
        human1.setName("Alex");
        System.out.println(human1.getName());
        
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Start search by Name: ");
        String get_user = iScanner.nextLine();
        iScanner.close();
        List<Human> res = tree.getHumanbyName(get_user);
        System.out.println(res);
    }
}
