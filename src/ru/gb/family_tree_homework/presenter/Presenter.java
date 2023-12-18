package ru.gb.family_tree_homework.presenter;

import ru.gb.family_tree_homework.UI.View;
import ru.gb.family_tree_homework.family_tree_API.human.Gender;
import ru.gb.family_tree_homework.family_tree_API.service.Service;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addFamilyMember(String name, Gender gender, LocalDate birthDate){
        service.addMember(name, gender, birthDate);
        getFamilyTreeInfo();
    }

    public Gender getGender(String strGender){
        return service.getInputGender(strGender);
    }

    public void getFamilyTreeInfo() {
        view.printAnswer(service.getFamilyTreeInfo());
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void getByName(String name){
        System.out.println(service.getByName(name));
    }

    public boolean setParent(long parentId, long childId){
        return service.setParent(parentId, childId);
    }

    public boolean setChild(long childId, long parentId){
        return service.setChild(childId, parentId);
    }

    public void remove(long id){
        service.remove(id);
    }

    public boolean setWedding(long humanId1, long humanId2){
        return service.setWedding(humanId1, humanId2);
    }

    public boolean setDivorce(long humanId1, long humanId2){
        return service.setDivorce(humanId1, humanId2);
    }

    public boolean saveTree(String fileName){
        return service.saveTree(fileName);
    }

    public boolean loadTree(String fileName){
        return service.loadTree(fileName);
    }
}
