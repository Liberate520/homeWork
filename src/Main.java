import java.io.IOException;
import java.util.Scanner;

import fileProcessing.Txt;
import project.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu() {
            @Override
            public void Greetings() {
                System.out.println("Добро пожаловать в генеалогическое древо.\n");
            }

            @Override
            public void MainMenu() {
                System.out.print("1. Показать древо\n" +
                                "2. Добавить человека\n" + 
                                "3. Поиск человека по имени\n" + 
                                "4. Загрузить древо\n" + 
                                "5. Сохранить древо\n" + 
                                "6. Завершить.\n" +
                                "Выберите действие : ");
            }

            @Override
            public void SecondMenu() {
                System.out.print("\n1. Показать детей\n" +
                                "2. Показать мать\n" +
                                "3. Показать отца\n" +
                                "4. В основное меню\n" +
                                "Выберите действие : ");
            }

            @Override
            public void FileHandler() {
                System.out.print("\n1. Txt\n" +
                                "2. Csv (в разработке)\n" +
                                "3. Json (в разработке)\n" +
                                "Выберите формат файла: ");
            }
        };
        FamilyTree tree = new FamilyTree();
        Scanner iScanner = new Scanner(System.in, "Cp866");
        menu.Greetings();
        Boolean flag = true;

        while (flag) {
            menu.MainMenu();
            String choice = iScanner.next();

            if (choice.equals("1")) System.out.println("\n" + tree.getTree());
            else if (choice.equals("2")) {
                System.out.print("\nВведите имя : "); String name = iScanner.next();
                System.out.print("Введите пол : "); String sex = iScanner.next();
                System.out.print("Введите имя отца (если не известно 'нет') : "); String name_father = iScanner.next();
                System.out.print("Введите имя матери (если не известно 'нет') : "); String name_mother = iScanner.next();
                add_new_human(tree, name, sex, name_father, name_mother);
                System.out.println(name + " Успешно добавлен в древо.\n");
            }
            else if (choice.equals("3")) {
                System.out.print("\nВведите имя : ");
                String name = iScanner.next();
                System.out.println(tree.getInfoHuman(name));
                menu.SecondMenu();
                choice = iScanner.next();
                if (choice.equals("1")) System.out.println("\nДети: " + tree.getInfoChildren(name));
                else if (choice.equals("2")) System.out.println("\nМать: " + tree.getInfoMother(name) + "\n");
                else if (choice.equals("3")) System.out.println("\nОтец: " + tree.getInfoFather(name) + "\n");    
            } 
            else if (choice.equals("4")) {
                System.out.println("\nВведите имя файла: ");
                String file_name = iScanner.next();
                menu.FileHandler();
                choice = iScanner.next();
                if (choice.equals("1")) {
                    tree = tree.open(file_name, new Txt());
                    System.out.println("Файл " + file_name + ".txt загружен\n");
                } else System.out.println("Нельзя загрузить");
            }
            else if (choice.equals("5")) {
                System.out.println("\nВведите имя файла: ");
                String file_name = iScanner.next();
                menu.FileHandler();
                choice = iScanner.next();
                if (choice.equals("1")) {
                    tree.save(file_name, new Txt());
                    System.out.println("Файл " + file_name + ".txt успешно сохранен\n");
                } else System.out.println("Нельзя сохранить");
            }
            else flag = false;
        }
        iScanner.close();
    }

    public static void add_new_human(FamilyTree tree, String name, String sex, String name_father, String name_mother) {
        if (name_father.equalsIgnoreCase("нет") && name_mother.equalsIgnoreCase("нет")) {
            tree.add(new Human(name, sex));
        } else if (name_father.equalsIgnoreCase("нет")) {
            tree.add(new Human(name, sex, null, tree.getHuman(name_mother)));
        } else if (name_mother.equalsIgnoreCase("нет")) {
            tree.add(new Human(name, sex, tree.getHuman(name_father), null));
        } else tree.add(new Human(name, sex, tree.getHuman(name_father), tree.getHuman(name_mother)));
    }
}