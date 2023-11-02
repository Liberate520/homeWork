package WorkSeminar.Consol;

import WorkSeminar.Persona.Persona;
import WorkSeminar.Program;
import WorkSeminar.SaveFile.SaveLoadTree;
import WorkSeminar.Tree.Tree;

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
        menu.append("4 - Показать древо.");
        menu.append("\n");
        menu.append("5 - Показать древо от младшего к старшему.");
        menu.append("\n");
        menu.append("6 - Показать древо по гендору:");
        menu.append("\n");
        menu.append("0 - Завершение работы..");
        menu.append("\n");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(menu);
            String enter = scanner.nextLine();
            switch (enter) {
                case "1":
                    tree = Program.newTree();
                    //System.out.println(tree);
                    System.out.println("Дерево создано!");
                    break;
                case "2":
                    SaveLoadTree saveTree = new SaveLoadTree();
                    saveTree.saveFile("src/WorkSeminar/SaveFile/saveTree.out", tree);
                    System.out.println("Древо сохранено! \n");
                    break;
                case "3":
                    SaveLoadTree loadTree = new SaveLoadTree();
                    tree = (Tree) loadTree.loadFile("src/WorkSeminar/SaveFile/saveTree.out");
                    System.out.println("Древо загружено: \n");
                    System.out.println(tree);
                    break;
                case "4":
                    // Проверка работы Итератора. РАБОТАЕТ
                    // Условно, считаем, что деволтное древо - от старшего к смладшему.
                    //TODO Пределать сортировку, что бы выводилось отсортированное древо, но само оно сохранялао прежнюю структуру.
                    tree.sortDefaut();
                    //TODO Вынести код в другой класс.
                    System.out.println("Показать древо: \n");
                    StringBuilder list = new StringBuilder();
                    for (Persona persona: tree){
                        list.append(persona);
                        list.append("\n");
                    }
                    System.out.println(list);
                    break;
                case "5":
                    // Проверка работы сортировки по возрастур от младшего к старешему.
                    System.out.println("Отсортированное древо по возрасту: \n");
                    tree.sortTreeByAge();
                    System.out.println(tree);
                    break;
                case "6":
                    // Проверка работы сортировки по гендору.
                    // TODO Сделать вывод только мальчиков или девочек.
                    System.out.println("Отсортированное древо по гендору: \n");
                    tree.sortTreeByGender();
                    System.out.println(tree);
                    break;
                case "0":
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
