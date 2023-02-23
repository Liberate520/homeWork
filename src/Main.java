import java.io.IOException;
import java.util.Scanner;

import fileProcessing.FileFormatTxt;
import project.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree tree = new FamilyTree();
        Scanner iScanner = new Scanner(System.in, "Cp866");
        Menu.greetings();
        Boolean flag = true;

        while (flag) {
            Menu.mainMenu();
            String choice = iScanner.next();

            if (choice.equals("1")) System.out.println("\n" + tree.getTree());
            else if (choice.equals("2")) {
                System.out.print("\nВведите имя : "); String name = iScanner.next();
                System.out.print("Введите пол : "); String sex = iScanner.next();
                System.out.print("Введите год рождения : "); Integer year_of_birth = iScanner.nextInt();
                System.out.print("Введите имя отца (если не известно 'нет') : "); String name_father = iScanner.next();
                System.out.print("Введите имя матери (если не известно 'нет') : "); String name_mother = iScanner.next();
                add_new_human(tree, name, sex, year_of_birth, name_father, name_mother);
                System.out.println(name + " Успешно добавлен в древо.\n");
            }
            else if (choice.equals("3")) {
                System.out.print("\nВведите имя : ");
                String name = iScanner.next();
                System.out.println(tree.getInfoHuman(name));
                Menu.secondMenu();
                choice = iScanner.next();
                if (choice.equals("1")) System.out.println("\nДети: " + tree.getInfoChildren(name));
                else if (choice.equals("2")) System.out.println("\nМать: " + tree.getInfoMother(name) + "\n");
                else if (choice.equals("3")) System.out.println("\nОтец: " + tree.getInfoFather(name) + "\n");    
            } 
            else if (choice.equals("4")) {
                System.out.print("\nВведите имя файла: ");
                String file_name = iScanner.next();
                Menu.fileHandler();
                choice = iScanner.next();
                if (choice.equals("1")) {
                    tree = tree.open(file_name, new FileFormatTxt());
                    System.out.println("Файл " + file_name + ".txt загружен\n");
                } else System.out.println("Нельзя загрузить");
            }
            else if (choice.equals("5")) {
                System.out.print("\nВведите имя файла: ");
                String file_name = iScanner.next();
                Menu.fileHandler();
                choice = iScanner.next();
                if (choice.equals("1")) {
                    tree.save(file_name, new FileFormatTxt());
                    System.out.println("Файл " + file_name + ".txt успешно сохранен\n");
                } else System.out.println("Нельзя сохранить");
            }
            else if (choice.equals("6")) {
                Menu.sortMenu();
                choice = iScanner.next();
                if (choice.equals("1")) {
                    tree.sortByName();
                    for (Human human : tree) {
                        System.out.println(human);
                    }
                    System.out.println();
                }
                else if (choice.equals("2")) {
                    tree.sortByYear();
                    for (Human human : tree) {
                        System.out.println(human);
                    }
                    System.out.println();
                }
            }
            else flag = false;
        }
        iScanner.close();
    }

    public static void add_new_human(FamilyTree tree, String name, String sex, Integer year_of_birth, String name_father, String name_mother) {
        if (name_father.equalsIgnoreCase("нет") && name_mother.equalsIgnoreCase("нет")) {
            tree.add(new Human(name, sex, year_of_birth));
        } else if (name_father.equalsIgnoreCase("нет")) {
            tree.add(new Human(name, sex, year_of_birth, null, tree.getHuman(name_mother)));
        } else if (name_mother.equalsIgnoreCase("нет")) {
            tree.add(new Human(name, sex, year_of_birth, tree.getHuman(name_father), null));
        } else tree.add(new Human(name, sex, year_of_birth, tree.getHuman(name_father), tree.getHuman(name_mother)));
    }
}