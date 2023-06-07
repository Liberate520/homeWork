package ru.gb.java;

import java.io.*;
import java.util.*;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Person> listPerson = new ArrayList<Person>();

        Menu menu = new Menu();
        SubMenu subMenu = new SubMenu();
        SubMenu2 subMenu2 = new SubMenu2();
        Tree tree = new Tree();
        SaveLoad sl = new SaveLoad();

        boolean flag = true;
        while (flag) {
            int choice = menu.MenuOut();

            Person person = new Person();

            switch (choice) {
                case 1:
                    listPerson.add(person.addPerson());
                    break;
                case 2:
                    person.addMultiplePersons(listPerson);
                    menu.MenuOut();
                    break;
                case 3:
                    int indexListPerson = subMenu2.subMenu(listPerson);
                    int menuItem = subMenu.subMenu();
                    switch (menuItem) {
                        case 1:
                            Branch branch1 = new Branch();
                            branch1.addBranch(listPerson.get(indexListPerson), true, true);
                            tree.addBranch(branch1);
                            break;
                        case 2:
                            Branch branch2 = new Branch();
                            branch2.addBranch(listPerson.get(indexListPerson), true, false);
                            tree.addBranch(branch2);
                            break;
                        case 3:
                            Branch branch3 = new Branch();
                            branch3.addBranch(listPerson.get(indexListPerson), false, true);
                            tree.addBranch(branch3);
                            break;
                    }
                    break;
                case 4:
                    tree.printBranch(listPerson);
                    break;
                case 5:
                    sl.save(listPerson, tree);
                    break;
                case 6:
                    sl.load();
                    break;
                case 7:
                    System.out.println(listPerson);;
                    break;
                case 8:
                    person.sortedNamePerson(listPerson);
                    break;
                case 9:
                    person.sortedDatePerson(listPerson);
                    break;
                case 10:
                    flag = false;
                    break;
            }
        }
    }
}