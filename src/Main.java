import Classes.FamilyTree;
import Classes.FileGuide;
import Classes.Human;
import Classes.TestInput;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.FileHandler;

import static Classes.Gender.female;
import static Classes.Gender.male;

public class Main {


    public static void main(String[] args) throws IOException {
        String pathToTreeFile = "src/tree.out";
        FileGuide fileGuide = new FileGuide();
        FamilyTree tree = new FamilyTree();
//         TestInput.TestInput(tree);//Тестовый вариант заполнения списка
//        System.out.println(tree.humanList.size());
//        System.out.println(tree.getInfo());
//        fileGuide.save(tree, pathToTreeFile);

//        FileGuide fileGuide =new FileGuide();
////        FamilyTree tree=new FamilyTree(); tree= (FamilyTree) fileGuide.read(pathToTreeFile);//Тоже работает
//        FamilyTree tree = (FamilyTree) fileGuide.read(pathToTreeFile);
//        System.out.println(tree.humanList.size());
//        System.out.println(tree.getInfo());
//    //    Human human = tree.humanList.get();
//        System.out.println(tree.humanList.get(2));
        boolean cycle = true;
        Scanner in = new Scanner(System.in);
        while (cycle) {
//                System.out.println("Пока обычное меню (с настраиваемым еще не разбирался)");
            System.out.println("   МЕНЮ >>>> Введите код операции: (Пока обычное меню (с настраиваемым еще не разбирался))");
            System.out.println("   МЕНЮ >>>> 0 - ВЫХОД             1-Тестовый ввод через код в \"TestInput\"    2-Сохранение в файл        3-Загрузка из файла");
//                System.out.println("1-Тестовый ввод через код в \"TestInput\"");
//                System.out.println("2-Сохранение в файл");
//                System.out.println("3-Загрузка из файла");
            System.out.println("   МЕНЮ >>>> 4-вывод списка людей    5-ввод персоны                            6-Добавить ребенка          7-Добавить родителя");
//                System.out.println("5-ввод персоны");
//                System.out.println("6-Добавить ребенка");
//                System.out.println("7-Добавить родителя");
            System.out.print("   МЕНЮ >>>> Вводим сюда>>>>>");
            String com = in.next();
            switch (com) {
                case ("0"): {
                    cycle = false;
                    break;
                }
                case ("1"): {
                    TestInput.TestInput(tree);//Тестовый вариант заполнения списка;
                    break;
                }
                case ("2"): {
                    fileGuide.save(tree, pathToTreeFile);
                    break;
                }
                case ("3"): {
                    tree = (FamilyTree) fileGuide.read(pathToTreeFile);
                    break;
                }
                case ("4"): {
                    System.out.println(tree.getInfo());
                    System.out.println("Список содержит записей: " + tree.humanList.size());
                    break;
                }
                case ("5"): {
                    System.out.println("Пока не работает");
                    break;
                }
                case ("6"): {
                    System.out.println("Пока не работает");
                    break;
                }
                case ("7"): {
                    System.out.println("Пока не работает");
                }
                default: {
                    System.out.println("Непонятная команда");
                    break;
                }
            }
//                cycle=false;

        }
    }


}
