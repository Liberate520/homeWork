package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.servise.FileHandler;
import ru.gb.family_tree.model.servise.TestData;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class Presenter <E> {
    private View view;
    private FamilyTree familyTree;
    private Service service;
    private FileHandler fileHandler;
    Scanner scanner;

    public Presenter(View view) {
        this.view = view;
        familyTree = TestData.testData();
        fileHandler = new FileHandler();;
        service = new Service();;
    }
    public void getTreeInfo(){
//        String answer = service.getTreeInfo();
        String answer = familyTree.getTreeInfo();
        System.out.println(answer);
    }
    // TODO доработать addHuman  - создать отдельный класс Service? ()
    public void addHuman(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday, LocalDate dateOfDeath){
        service.addHuman(numPassport, surname, name, gender, birthday, dateOfDeath);
        getTreeInfo();
    }
    public String searchHuman(String value){
        String answerSeach = String.valueOf(familyTree.searchHuman(value));
        System.out.println(answerSeach);
        return answerSeach;
    }
    // TODO доработать addKid
    public void addKid(String name, Human.Gender gender, LocalDate birthday){
//        getTreeInfo();
//        System.out.println("Выберите родителя из списка (введите номер паспорта): \n");
//        String value = scanner.nextLine();
//        String answer = searchHuman(value);
        service.addToKids(name, gender, birthday);
    }
    // TODO доработать addParent
    public void addParent(String surname, String name, Human.Gender gender){
//        familyTree.addToParents(surname, name, gender);
    }
    // TODO доработать addPartner
    public void addPartner(String surname, String name, Human.Gender gender) {
//        familyTree.addToPartner(surname, name, gender);
    }

    public void sortByName(){
        familyTree.sortByName();
        getTreeInfo();
    }
    public void sortByAge() {
        familyTree.sortByAge();
        getTreeInfo();
    }
    public void sortByBirthday(){
        familyTree.sortByBirthday();
        getTreeInfo();
    }
    // TODO методы saveInFile() и loadFromFile() убрать в отд. class FileManager ->
    public void saveInFile() {
        fileHandler.save(familyTree, "src/ru/gb/family_tree/tree.out");
        System.out.println("экспорт (tree.out) завершен успешно");
    }
    public void loadFromFile() {
//        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = (FamilyTree) fileHandler.loading("src/ru/gb/family_tree/tree.out");
        System.out.println("Импорт данных выполнен  >>>>>>  " + familyTree);
    }
}
