package family_tree;

import family_tree.file_handler.FileHandler;
import family_tree.creatures.Human;
import family_tree.creatures.enums.Gender;
import family_tree.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Тестирование записи и чтения из файла (initTree - экземпляр для записи; tree1 - экземпляр для чтения)
        FamilyTree<Human> initTree = new FamilyTree<>();
        fillFamilyTree(initTree);
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(initTree, "src/family_tree/saves/FamilyTree.txt");
        FamilyTree<Human> tree1;
        tree1 = (FamilyTree) fileHandler.read("src/family_tree/saves/FamilyTree.txt");

        boolean check1 = true, check2;
        int option;
        while (check1) {
            check2 = true;
            System.out.println("Введите цифру, соответствующую нужной опции.\n" +
                    "1) Отобразить всех людей в семейном дереве.\n" +
                    "2) Завершить работу с программой.");
            System.out.println("----------------------------");
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        while (check2) {
                            System.out.println("----------------------------");
                            tree1.sortByDateOfBirth();
                            System.out.println(tree1.toString());
                            System.out.println("----------------------------");
                            System.out.println("Введите цифру, соответствующую нужной опции.\n" +
                                    "1) Отобразить определённые связи для конкретного человека.\n" +
                                    "2) Вернуться в главное меню.");
                            System.out.println("----------------------------");
                            if (sc.hasNextInt()) {
                                option = sc.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("Введите цифру, соответствующую нужному человеку.");
                                        System.out.println("----------------------------");
                                        if (sc.hasNextInt()) {
                                            option = sc.nextInt();
                                            if (option <= tree1.getFamilyTree().size()) {
                                                System.out.println(tree1.getFamilyTree().get(option-1).viewAllFamily());
                                            }
                                            System.out.println("----------------------------");
                                        } else {
                                            sc.next();
                                            break;
                                        }
                                    case 2:
                                        check2 = false;
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                sc.next();
                            }
                        }
                    }
                    case 2 -> check1 = false;
                    default -> {
                    }
                }
            }else{
                sc.next();
            }
        }
    }

    public static void fillFamilyTree(FamilyTree familyTree) {
        Human human1 = new Human(
                1,
                "Дмитрий",
                "Иванов",
                Gender.Male,
                LocalDate.of(1949, 8, 14),
                LocalDate.of(1989, 12, 2));
        Human human2 = new Human(
                2,
                "Анна",
                "Иванова",
                Gender.Female,
                LocalDate.of(1951, 9, 3));
        Human human3 = new Human(
                3,
                "Степан",
                "Сугако",
                Gender.Male,
                LocalDate.of(1950, 3, 21));
        Human human4 = new Human(
                4,
                "Оксана",
                "Сугако",
                Gender.Female,
                LocalDate.of(1952, 2, 16));
        Human human5 = new Human(
                5,
                "Илья",
                "Иванов",
                Gender.Male,
                LocalDate.of(1972, 3, 22),
                LocalDate.of(2015, 1, 12));
        Human human6 = new Human(
                6,
                "Владимир",
                "Сугако",
                Gender.Male,
                LocalDate.of(1972, 11, 3));
        Human human7 = new Human(
                7,
                "Виктория",
                "Сугако",
                Gender.Female,
                LocalDate.of(1973, 5, 4));
        Human human8 = new Human(
                8,
                "Наталья",
                "Сугако",
                Gender.Female,
                LocalDate.of(1994, 3, 13));
        Human human9 = new Human(
                9,
                "Анна",
                "Сугако",
                Gender.Female,
                LocalDate.of(1996, 10, 2));

        human1.setSpouse(human2);
        human1.addChildren(human5);
        human1.addChildren(human7);

        human2.setSpouse(human1);
        human2.addChildren(human5);
        human2.addChildren(human7);

        human3.setSpouse(human4);
        human3.addChildren(human6);

        human4.setSpouse(human3);
        human4.addChildren(human6);

        human5.setFather(human1);
        human5.setMother(human2);

        human6.setSpouse(human7);
        human6.setFather(human3);
        human6.setMother(human4);
        human6.addChildren(human8);
        human6.addChildren(human9);

        human7.setSpouse(human6);
        human7.setFather(human1);
        human7.setMother(human2);
        human7.addChildren(human8);
        human7.addChildren(human9);

        human8.setFather(human6);
        human8.setMother(human7);

        human9.setFather(human6);
        human9.setMother(human7);

        familyTree.addCreature(human1);
        familyTree.addCreature(human2);
        familyTree.addCreature(human3);
        familyTree.addCreature(human4);
        familyTree.addCreature(human5);
        familyTree.addCreature(human6);
        familyTree.addCreature(human7);
        familyTree.addCreature(human8);
        familyTree.addCreature(human9);

    }
}

