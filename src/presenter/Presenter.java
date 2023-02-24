package src.presenter;

import src.*;
import src.comparator.SortBy;
import src.ui.View;

import java.io.IOException;
import java.util.Scanner;

public class Presenter {
    //каким образом закинем модель в презентер?
    private View view;
    private FamilyTree<Human> familyTree;
    public Presenter(View view, FamilyTree familyTree){
        this.view = view;
        this.familyTree = familyTree;
        view.setPresenter(this);
    }

    public void addHuman(){
        Stat stat = new Stat(familyTree.maxId());
        Human h = new Human();
        h.createUnit();
        familyTree.addToFamily(h);
    }
    public void delHuman(){
        //или лучше снести это всё в delUnit???
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите ID который хотите удалить: ");
        String id = scanner.next();
        if (validation.isNextInt(id)) {
            int delId = Integer.parseInt(id);
            if (familyTree.delUnit(delId)) {
                System.out.printf("\nЗапись с ID: %d удалена!\n", delId);
            } else {
                System.out.printf("Запись с ID: %s не была удалена", id);
            }
        }

    }
    public void findHumans(){
        System.out.println("Заглушка");
    }
    public void showTree(){
        System.out.println("Заглушка");
    }
    public void showHuman(){
        System.out.println("Заглушка");
    }


    public void showHumans() {
        familyTree.sort(SortBy.DATE_OF_BIRTH);
        for (Human h :
                familyTree) {
            System.out.println(h);
        }
    }

    public void saveTree(){
        try {
            familyTree.save();
            System.out.println("Файл сохранен!\n");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так!!! Файл не сохранен...");
            throw new RuntimeException(e);
        }
    }
}
