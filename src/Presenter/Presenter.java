package Presenter;


import java.util.ArrayList;

import Model.FamilyTree;
import Model.Human;
import Model.Instance;
import view.View_tree;
import Model.Pet;

public class Presenter {
    private View_tree view;
    private FamilyTree tree;



    public Presenter(View_tree view, FamilyTree tree) {
        this.view = view;
        this.tree = tree;

    }

    public ArrayList<Instance> getTreeList(){
        return this.tree.getTreeList();
    }
    // 1.Вывести инфо по представителю по id \n2. Найти потомков по id родителя \n3.Найти братьев/сестер по id представителя \n4. Вывести все дерево потомков от id представителя
    public void tree_human() {
        System.out.println("Загружаем генеалогическое дерево Human");
        while (true) {   
        
            int menu_select = view.menu();
            switch (menu_select) {
                case 1:
                System.out.println("Введите id представителя");
                    int id = view.userInput();
                    view.print(id, getTreeList());
                    break;
                case 2:
                    System.out.println("Введите id представителя");
                    id = view.userInput();
                    tree.getChildren(id, getTreeList());
                    break;
                case 3:
                    System.out.println("Введите id представителя");
                    id = view.userInput();
                    tree.getKins(id, getTreeList());
                    break;
                case 4:
                    System.err.println("Заглушка, не придумал красивый ступенчатый вывод с рекурсией");
                    break;
            }  
            if (menu_select == 5) break;
        } 
    }

    public void pet_tree() {
        System.out.println("\nЗагружаем дерево  животных \n");
        for (int index = 0; index < getTreeList().size(); index++) {
            view.print(index, getTreeList());
        }
        System.out.println("Тут далее немного другое меню, - как с людьми, только можно добавить какие-то награды и заменить на сук/кобелей/ Не доделал");
    }


}

