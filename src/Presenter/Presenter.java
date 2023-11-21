package Presenter;
import Model.human.Human;
import Model.tree.FamilyTree;
import Model.tree.FamilyTreeItem;
import Model.writer.FileHandler;
import Model.writer.Writable;
import View.Commands.SetChild;
import View.View;
import Model.Service.Service;

import java.util.Scanner;

public class Presenter<T extends FamilyTreeItem<T> > {

    private View view;
    private Service service;
//    private FamilyTree<Human> familyTree;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void addHuman(Human human){

        service.addHuman(human);
    }

    public void getHumanListInfo(){
        String answer = service.getHumanListInfo();
        view.answer(answer);
//        System.out.println(list);
    }

    public void load(){
        service.read();

    }
    public void save(){
        service.save();
        System.out.println(service.getHumanListInfo());

    }

    public void sortByAge(){
        service.sortByAge();
//        getHumanListInfo();
    }

    public void sortByName(){
        service.sortByName();
//        getHumanListInfo();
    }

    public void sortBySurname(){
        service.sortByLastname();
//        getHumanListInfo();
    }
    public void sortById(){
        service.sortById();
    }

    public void searchByName(){
        System.out.println("Введите ключевое слово: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(service.searchByNameSurname(name));
    }

    public void setChild(){
        System.out.println("Введите ID родителя: ");
        Scanner scanner = new Scanner(System.in);
        String idParentStr = scanner.nextLine();
        int idParent = Integer.parseInt(idParentStr);
        System.out.println("Введите ID ребенка: ");
        String idChildStr = scanner.nextLine();
        int idChild = Integer.parseInt(idChildStr);
        T parent = (T) service.searchById(idParent);
        T child = (T) service.searchById(idChild);
        parent.setChild(child);

    }

    public void getId(T human){
        service.getId(human);
    }

    @Override
    public String toString() {
        return service.getHumanListInfo();
    }
}