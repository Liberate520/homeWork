package Homework_004;

import java.io.IOException;

import Homework_004.controller.Controller;
import Homework_004.model.*;
import Homework_004.view.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        View view = new ConsoleUI();
        Controller controller = new Controller(view);
        view.start();

//для заполнения файла и отладки
        // FamilyTree<Human> familyTree = new FamilyTree<>();
        // FamilyTree<Pet> petFamilyTree = new FamilyTree<>();
        // Human human0 = new Human("Иван", "м", "10.01.1965");
        // Human human1 = new Human("Мария", "ж", "16.02.1965");
        // Human human2 = new Human("Петр", "м", "16.02.1940");
        // Human human3= new Human("Николай", "м", "12.01.1990");
        // Human human4 = new Human("Ирина", "ж", "15.02.1992");
        // Pet pet0 = new Pet("Мурзик", "м", "10.05.2005");
        // human0.setParent(human2);
        // human3.setParent(human0);
        // human3.setParent(human1);
        // human4.setParent(human1);
        // familyTree.add(human0);
        // familyTree.add(human1);
        // familyTree.add(human2);
        // familyTree.add(human3);
        // familyTree.add(human4);
        // petFamilyTree.add(pet0);

        // System.out.println(familyTree.getAll());
        // System.out.println(petFamilyTree.getAll());

        // FamilyTreeService newFamilyTreeService = new FamilyTreeService(familyTree);
        // newFamilyTreeService.sortById();
        // System.out.println("Сортировка  по  ID:");
        // System.out.println(familyTree.getAll());

        // newFamilyTreeService.sortByName();

        // System.out.println("Сортировка по name:");
        // System.out.println(familyTree.getAll());

        // newFamilyTreeService.sortByDate();

        // System.out.println("Сортировка по date:");
        // System.out.println(familyTree.getAll());

        // Research research1 = new Research(familyTree, human4);

        // System.out.println("Братья " + human4.getName() + " :" + research1.getBrothers() + "\n");

        // System.out.println("Записанные в файл:");
        // System.out.println(familyTree.getAll());
        // Writer writer = new Writer();
        // writer.save(familyTree);

        // FamilyTree familyTreeRestored = writer.read();
        // System.out.println("\nВосстановленные:");
        // System.out.println(familyTreeRestored.getAll());

    }
}