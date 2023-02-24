package org.example.gui;

import org.example.Gender;
import org.example.Human;
import org.example.Tree;
import java.util.Scanner;

public class ConsoleUi {
    private final Scanner scanner;
    private final Tree<Human> tree;


    public ConsoleUi(Tree<Human> tree) {
        this.tree = tree;
        this.scanner = new Scanner(System.in);
    }


    private void clear(){
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
    }

    public void print(String text) {
        System.out.println(text);
    }


    public void start(){
        boolean flag = false;
        while (!flag) {
            print("1 - Вывод на экран\n2 - Добавить человека\n3 - Добавить/изменить данные\n" +
                    "4 - Удалить человека из списка\n5 - Выход\n");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {           // Печать
                    clear();
                    print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                    tree.printNamesHuman(tree.getBigFamily());
                    input = scanner.nextLine();
                    clear();
                    tree.superPrintHumanHC(tree.getBigFamily(), Integer.parseInt(input) - 1);                                //Human.superPrintHumanHC(treeFamDem, Integer.parseInt(input) - 1);

                }
                case "2" ->  {
                    clear();
                    print("***Введите Ф.И.О***");
                    String name = scanner.nextLine();                      // Добавить человека
                    tree.addHuman(new Human(name, tree));
                    clear();
                }
                case "3" -> {    // Изменить данные человека
                    clear();
                    print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                    tree.printNamesHuman(tree.getBigFamily()); // вывод списка Human по именам
                    input = scanner.nextLine();
                    boolean flag2 = false;
                    while (!flag2) {
                        clear();
                        print("*******ЧТО ВЫ ХОТИТЕ ДОБАВИТЬ/ИЗМЕНИТЬ ?*******\n");
                        tree.printHuman(tree.getBigFamily(),Integer.parseInt(input) - 1);
                        print("1 - Ф.И.О.\n2 - ПОЛ\n3 - ДАТУ РОЖДЕНИЯ\n4 - ДОБАВИТЬ/РЕДАКТИРОВАТЬ ДАТУ СМЕРТИ\n" +
                                "5 - mother\n6 - father\n7 - children\n8 - brothersAndSisters\n9 - Вернуться в предыдущее меню\n");
                        switch (Integer.parseInt(scanner.nextLine())) {
                            case 1 -> {
                                print("***Введите Ф.И.О***");
                                ((tree.getBigFamily().get(Integer.parseInt(input) - 1))).setName(scanner.nextLine());
                                clear();
                            }
                            case 2 -> {
                                print("1 - Мужчина");
                                print("2 - Женщина");
                                String input2 = scanner.nextLine();
                                if (input2.equals("1")){
                                    ((tree.getBigFamily().get(Integer.parseInt(input) - 1))).setGender(Gender.male);
                                } else{
                                    ((tree.getBigFamily().get(Integer.parseInt(input) - 1))).setGender(Gender.female);
                                }
                                clear();
                            }
                            case 3 -> {
                                print("Ведите дату формате -день%месяц%год-");
                                String input2 = scanner.nextLine();
                                ((tree.getBigFamily().get(Integer.parseInt(input) - 1))).setDateOfBirth(Human.creatingADate(input2));
                                clear();
                            }
                            case 4 -> {
                                print("Ведите дату формате -день%месяц%год-");
                                String input2 = scanner.nextLine();
                                ((tree.getBigFamily().get(Integer.parseInt(input) - 1))).setDateOfDeath(Human.creatingADate(input2));
                                clear();
                            }
                            case 5 -> {
                                print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                                tree.printNamesHuman(tree.getBigFamily());
                                String input2 = scanner.nextLine();
                                Human mother = tree.getBigFamily().get(Integer.parseInt(input2) - 1);
                                Human children = tree.getBigFamily().get(Integer.parseInt(input) - 1);
                                children.setMother(mother);
                                // Присваиваем ребенку мать автомотически матери присваивается ребенок так же и отцу далее..
                                mother.setChildren(children);
                                clear();
                            }
                            case 6 -> {
                                print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                                tree.printNamesHuman(tree.getBigFamily());
                                String input2 = scanner.nextLine();
                                Human father = tree.getBigFamily().get(Integer.parseInt(input2) - 1);
                                Human children = tree.getBigFamily().get(Integer.parseInt(input) - 1);
                                children.setFather(father);
                                father.setChildren(children);
                                clear();
                            }
                            case 7 ->{
                                print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                                tree.printNamesHuman(tree.getBigFamily());
                                String input2 = scanner.nextLine();
                                Human children = tree.getBigFamily().get(Integer.parseInt(input2) - 1);
                                Human parent = tree.getBigFamily().get(Integer.parseInt(input) - 1);
                                parent.setChildren(children);
                                // присваиваем человеку ребенка и если человек мужчина у ребенка присваевается отец , если человек женщина...
                                if (parent.getGender() == Gender.male){
                                    children.setFather(parent);
                                } else {
                                    children.setMother(parent);
                                }
                                clear();
                            }
                            case 8 -> {
                                print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                                tree.printNamesHuman(tree.getBigFamily());
                                String input2 = scanner.nextLine();

                                Human brothersAndSisters = tree.getBigFamily().get(Integer.parseInt(input2) - 1);
                                Human human = tree.getBigFamily().get(Integer.parseInt(input) - 1);
                                human.setBrothersAndSisters(brothersAndSisters);
                                brothersAndSisters.setBrothersAndSisters(human);
                                clear();
                            }
                            case 9 -> {
                                flag2 = true;
                                clear();
                            }
                        }
                    }
                }
                case "4" -> {
                    clear();
                    print("*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n");
                    tree.printNamesHuman(tree.getBigFamily());
                    input = scanner.nextLine();
                    clear();
                    tree.removingAPerson(tree.getBigFamily(), Integer.parseInt(input) - 1);
                }
                case "5" -> flag = true;
            }
        }
        scanner.close();
    }



}
