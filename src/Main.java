import family_tree.model.tree.TreeNode;
//import static family_tree.model.base.FileHandler.FileHandlerForFamilyTree;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

import java.io.*;


public class Main<E extends TreeNode<E>> {
    public static void main(String[] args) throws IOException  {
        // выводим на экран familyTree
//        party();
        // выводим на экран
//        System.out.println("===============================");
//        System.out.println("Список : ");
//        System.out.println("Фамильное дерево : ".toUpperCase());
//        FileHandlerForFamilyTree();
//        System.out.println("Список : ");
//        HandlerForTree();
//        System.out.println("                    FAMILY TREE");
//        System.out.println("===============================");
//        System.out.println("===============================");

        View view = new ConsoleUI();
        view.start();

    }


//    private static extends TreeHub void party() {
//        FamilyTree familyTree = new FamilyTree(123);
//        Human human1 = new Human("Ивановский", "Иван Семенович", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Formal,350000.0, 32, 0.1);
//        Human human2 = new Human("Семенова", "Марианна Петровна", Gender.Female, Position.Mother, SocialPosition.Married, Fondation.Formal,350000.0, 30, 0.2);
//        Human human3 = new Human("Семенов", "Денис Петрович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Informal,950000.0, 27, 0.3);
//        Human human4 = new Human("Савельев", "Петр Сергеевич", Gender.Male, Position.Father, SocialPosition.Not_married, Fondation.Informal,50000.0, 43, 0.4);
//        Human human5 = new Human("Живнов", "Марат Клементьевич", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Informal,600000.0, 50, 0.5);
//        Human human6 = new Human("Алябьева", "Маргарита Васильевна", Gender.Female, Position.Mother, SocialPosition.Not_married, Fondation.Informal,135000.0, 39, 0.6);
//        Human human7 = new Human("Ивановский", "Михаил Иванович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Non_formal,5000.0, 14, 0.7);
//        Human human8 = new Human("Алябьев", "Петр Маратович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Formal,10000.0, 20, 0.8);
//
//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
//        familyTree.addHuman(human3);
//        familyTree.addHuman(human4);
//        familyTree.addHuman(human5);
//        familyTree.addHuman(human6);
//        familyTree.addHuman(human7);
//        familyTree.addHuman(human8);
//
//        System.out.println(familyTree.getRelativeInfo());
////        familyTree.getRelativeInfo.sortByLastName();
////        System.out.println(familyTree);
//    }



}
