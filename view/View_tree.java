package view;

import Model.FamilyTree;
import Model.Human;
import Model.Instance;
import Presenter.Presenter;

import java.util.ArrayList;
import java.util.Scanner;

public class View_tree {
    Presenter pr;


    public void print(int id, ArrayList<Instance> base) {
        Instance person = base.get(id);
        System.out.println("\n Данные на - " + person.getName());
        System.out.println("Имя - " + person.getName() + ",\n родился: ");
        System.out.printf("%d/%d/%d \n", person.getYear(), person.getMonth(), person.getDay());
        if (person instanceof Human) {
            if (person.getFather_id() > 0) System.out.println("Отец - " + base.get(person.getFather_id()).getName());
            if (person.getMother_id() > 0)System.out.println("Мать - " + base.get(person.getMother_id()).getName());
            if (person.getPartner() > 0) System.out.println("В браке с - " + base.get(person.getPartner()).getName());
        }
        // if (person instanceof Pet) {
        //     if (person.getFather_id() > 0) System.out.println("Кобель - " + base.get(person.getFather_id()).getName());
        //     if (person.getMother_id() > 0)System.out.println("Сука - " + base.get(person.getMother_id()).getName());

        // }        
    }

    public int userInput() {

        Scanner cs = new Scanner(System.in);
        int num = cs.nextInt();

        return num;
    }

    public int menu() {
        System.out.println("\nВведите номер menu: \n1. Вывести инфо по представителю по id \n2. Найти потомков по id родителя \n3. Найти братьев/сестер по id представителя \n4. Вывести весь дерево потомков от id представителя \n5. Exit");
        int menu_select = userInput();
        return menu_select;
    }

    public void printAllTree(ArrayList<Instance> base) {
        for (int index = 0; index < base.size(); index++) {
            
            }
    }

            
        
}





