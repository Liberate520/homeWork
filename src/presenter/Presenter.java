package src.presenter;

import src.*;
import src.comparator.SortBy;
import src.ui.ConsoleForms;
import src.ui.View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Presenter {
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
        ConsoleForms form = new ConsoleForms();
        List<Human> findRes = familyTree.unPackArgsFindHumans(form.findForm());
        System.out.println("Результаты поиска:");
        for (Human h :
                findRes) {
            System.out.println(h);
        }
    }
    public void showTree(){
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите \"родительский\" ID от которого будет стоиться деверо: ");
        String sc = scanner.next();
        if(validation.isNextInt(sc)){
            familyTree.displayTree(familyTree.getUnitById(Integer.parseInt(sc)));
        }
    }
    public void infoHuman(){
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите ID информацию по которому хотите получить: ");
        String sc = scanner.next();
        if(validation.isNextInt(sc)){
            familyTree.getStatistics(familyTree.getUnitById(Integer.parseInt(sc)));
        }
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
