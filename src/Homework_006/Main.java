package Homework_006;

import java.io.IOException;

import Homework_006.controller.Controller;
import Homework_006.model.*;
import Homework_006.view.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        View view = new ConsoleUI();
        FamilyTreeService service = new FamilyTreeService();
        Controller controller = new Controller(view, service);
        view.start();


        
//для заполнения файла и отладки
        // FamilyTree<Human> familyTree = new FamilyTree<>();
        // Human human0 = new Human("Иван", "м", "10.01.1965");
        // Human human1 = new Human("Мария", "ж", "16.02.1965");
        // Human human2 = new Human("Петр", "м", "16.02.1940");
        // Human human3 = new Human("Николай", "м", "12.01.1990");
        // Human human4 = new Human("Ирина", "ж", "15.02.1992");
        // Human human5 = new Human("Павел", "м", "10.05.1995");
        // familyTree.add(human0);
        // familyTree.add(human1);
        // familyTree.add(human2);
        // familyTree.add(human3);
        // familyTree.add(human4);
        // familyTree.add(human5);
        // human0.setParent(human2);
        // human3.setParent(human0);
        // human4.setParent(human0);
        // human5.setParent(human0);
        // human3.setParent(human1);
        // human4.setParent(human1);
        // human5.setParent(human1);
        // Writer writer = new Writer();
        // writer.save(familyTree);
        // System.out.println(familyTree.getAll());

    }
}