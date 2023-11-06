package model_app;

import java.io.*;
import static family_tree.base.FileHandler.FileHandlerForFamilyTree;

public class Main {
    public static void main(String[] args) throws IOException  {

        // выводим на экран
        System.out.println("===============================");
        System.out.println("Список : ");
        System.out.println("Фамильное Дерево : ");
//        party()
        FileHandlerForFamilyTree();
        System.out.println("                    FAMILY TREE");
        System.out.println("===============================");

    }

//    private static <E extends TreeHub<E>> void party() {
//        FamilyTree<E> familyTree = new FamilyTree<E>(123);
//        Human<E> human1 = new Human<E>("Ивановский", "Иван Семенович", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Formal,350000.0, 32, 0.1);
//        Human<E> human2 = new Human<E>("Семенова", "Марианна Петровна", Gender.Female, Position.Mother, SocialPosition.Married, Fondation.Formal,350000.0, 30, 0.2);
//        Human<E> human3 = new Human<E>("Семенов", "Денис Петрович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Informal,950000.0, 27, 0.3);
//        Human<E> human4 = new Human<E>("Савельев", "Петр Сергеевич", Gender.Male, Position.Father, SocialPosition.Not_married, Fondation.Informal,50000.0, 43, 0.4);
//        Human<E> human5 = new Human<E>("Живнов", "Марат Клементьевич", Gender.Male, Position.Father, SocialPosition.Married, Fondation.Informal,600000.0, 50, 0.5);
//        Human<E> human6 = new Human<E>("Алябьева", "Маргарита Васильевна", Gender.Female, Position.Mother, SocialPosition.Not_married, Fondation.Informal,135000.0, 39, 0.6);
//        Human<E> human7 = new Human<E>("Ивановский", "Михаил Иванович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Non_formal,5000.0, 14, 0.7);
//        Human<E> human8 = new Human<E>("Алябьев", "Петр Маратович", Gender.Male, Position.Son, SocialPosition.Not_married, Fondation.Formal,10000.0, 20, 0.8);
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

