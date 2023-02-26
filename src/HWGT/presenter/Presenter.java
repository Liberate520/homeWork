package HWGT.presenter;

import HWGT.model.FamilyTree;
import HWGT.model.commands.*;
import HWGT.ui.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private FamilyTree familyTree = new FamilyTree();
    private TestTree testTree = new TestTree(familyTree);
    private PrintTree printTree = new PrintTree(familyTree);
    private SortByName sortByName = new SortByName(familyTree);
    private SortByBirth sortByBitrh = new SortByBirth(familyTree);
    private SearchPerson searchPerson = new SearchPerson(familyTree);
    private AddPerson addPerson = new AddPerson(familyTree);
    private UpdatePerson updatePerson = new UpdatePerson(familyTree);
    private PersonEnvironment personEnvironment = new PersonEnvironment(familyTree);
    private SaveData saveData = new SaveData(familyTree);
    private LoadData loadData = new LoadData(familyTree);


    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void testTree() {
        testTree.fillTestTree(familyTree);
        System.out.println("тестовое дерево создано");
    }

    public void loadData() throws IOException, ClassNotFoundException {

        familyTree = loadData.doIt(familyTree);
        // loadData.doIt(familyTree) где doiT - void данные не возвращаются
        System.out.println("загрузка работает");
    }

    public void saveData() throws IOException {
        saveData.doIt(familyTree);
        System.out.println("сохранение работает");
    }

    public void addPerson() {
        addPerson.toFamilyTree(familyTree);
        System.out.println("добавление человека работает");
    }

    public void updatePerson() {
        updatePerson.dataInFamilyTree(familyTree);
        System.out.println("изменение данных работает");
    }

    public void personEnvironment() {
        personEnvironment.updateData(familyTree);
        System.out.println("изменение данных об окружении работает");
    }

    public void searchPerson(String nextLine) {
        searchPerson.getPerson(familyTree, nextLine);
        System.out.println("поиск человека работает");
    }
    public void printTree() {

        printTree.getFamilyTree (familyTree);
        System.out.println("вывод всех записей на экран работает");
    }

    public void sortByName() {
        sortByName.getSort(familyTree);
        printTree.getFamilyTree (familyTree);
        System.out.println("сортировка по имени работает");
    }

    public void sortByBirthDate() {
        sortByBitrh.getSort(familyTree);
        printTree.getFamilyTree (familyTree);
        System.out.println("сортировка по году рождения работает");
    }
}