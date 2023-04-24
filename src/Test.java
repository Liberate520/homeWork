package Tree.homeWork.src;

import Tree.homeWork.src.FamilyTree;
import Tree.homeWork.src.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

//        Human human1 = new Human("Ivanov Stanislav Aleksandrovich", 33, 1990,2023, Gender.Male, TypeCommunication.son);
//        Human human2 = new Human("Ivanova",55,1968,0,Gender.Female, TypeCommunication.mother);
//        Human human3 = new Human("Misha", 3,2020,0,Gender.Male,TypeCommunication.children);
//        Human human4 = new Human("Babushka Galya", 75,1948,0,Gender.Female,TypeCommunication.grandmother);
        FamilyTree familyTree = new FamilyTree();
//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
//        familyTree.addHuman(human3);
//        familyTree.addHuman(human4);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите данные о человеке '0' или команду '1' показать или 'q' для выхода): ");
            String user_input = scanner.nextLine();
            if (user_input.equals("0")){
                Human human10 = new Human();        // РЕАЛИЗОВАТЬ ВВОД ДАННЫХ
                familyTree.addHuman();
            } else if (user_input.equals("1")) {
                familyTree.getHumanList();
                System.out.println(familyTree);
            } else if (user_input.equals("q")) {
                break;
        }
        scanner.close();
        }
        System.out.println(familyTree.getHumanList());
        Human human = new Human(null);
    }
}
