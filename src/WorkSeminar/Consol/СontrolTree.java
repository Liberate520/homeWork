package WorkSeminar.Consol;

import WorkSeminar.Program;
import WorkSeminar.SaveFile.SaveLoadTree;
import WorkSeminar.Tree;

import java.io.IOException;
import java.util.Scanner;



public class СontrolTree {
        public static void ControlMain(){
            Tree tree = new Tree();

        StringBuilder menu = new StringBuilder();
        menu.append("Базовое меню: ");
        menu.append("\n");
        menu.append("1 - Cоздать семейное древо.");
        menu.append("\n");
        menu.append("2 - Сохранение.");
        menu.append("\n");
        menu.append("3 - Загрузка.");
        menu.append("\n");
        menu.append("4 - Завершение работы..");
        menu.append("\n");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(menu);
            String enter = scanner.nextLine();
            switch (enter) {
                case "1":
                    tree = Program.newTree();
                    System.out.println(tree);
                    break;
                case "2":
                    SaveLoadTree saveTree = new SaveLoadTree();
                    saveTree.saveFile("src/WorkSeminar/SaveFile/saveTree.out", tree);
                    System.out.println("Древо сохранено! \n");
                    break;
                case "3":
                    SaveLoadTree loadTree = new SaveLoadTree();
                    tree = (WorkSeminar.Tree) loadTree.loadFile("src/WorkSeminar/SaveFile/saveTree.out");
                    System.out.println("Древо загружено: \n");
                    System.out.println(tree);
                    break;
                case "4":
                    System.out.println("Завершение работы... \n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ошибка ввода! \n");
                    scanner.close();
                    break;
            }

        }


    }
}
