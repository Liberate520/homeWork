package HWGT.presenter;

import HWGT.model.FamilyTree;
import HWGT.model.Service;
import HWGT.ui.View;
import HWGT.model.DataService;
import HWGT.model.PrintService;

import java.io.IOException;

public class Presenter {
      private View view;
      private FamilyTree familyTree = new FamilyTree();

    private Service service = new Service(familyTree);
    private PrintService printService = new PrintService(familyTree);
    private DataService dataService = new DataService(familyTree);
    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void testTree() {
        service.fillTestTree(familyTree);
        System.out.println("тестовое дерево создано");
    }

    public void loadData() throws IOException, ClassNotFoundException {

        familyTree = dataService.LoadData();
        System.out.println("загрузка работает");
    }

    public void saveData() throws IOException {
        dataService.saveData();
        System.out.println("сохранение работает");
    }

    public void addPerson() {
        service.addPerson(familyTree);
        System.out.println("добавление человека работает");
    }

    public void updatePerson() {
        service.updatePerson(familyTree);
        System.out.println("изменение данных работает");
    }

    public void personEnvironment() {
        service.personEnvironment(familyTree);
        System.out.println("изменение данных об окружении работает");
    }

    public void searchPerson(String nextLine) {
        service.searchPerson(familyTree, nextLine);

        System.out.println("поиск человека работает");
    }


    public void sortByName() {
        service.sortByName(familyTree);
        printService.printTree(familyTree);
        System.out.println("сортировка по имени работает");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate(familyTree);
        printService.printTree(familyTree);
        System.out.println("сортировка по году рождения работает");
    }

    public void printTree(){
        printService.printTree(familyTree);
    }
}