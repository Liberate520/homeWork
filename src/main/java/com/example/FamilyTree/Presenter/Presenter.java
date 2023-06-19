package com.example.FamilyTree.Presenter;

import com.example.FamilyTree.Model.Model;

import java.util.List;
import java.util.Map;

public class Presenter {
    private Model model = new Model();

    public List<String> getObjectList() {
        return model.getObjectList();
    }

    public String RunFamilyTree(String objectSelection) {
        model.getFamilyTree(objectSelection);
        if (model.familyEmpty()) {
            return "Семейное дерево "+objectSelection+" пустое";
        } else {
            return takeSortingFamilyTree();
        }
    }

    private String takeSortingFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Общий список лиц семьи: " + model.printFamilyTree(-1,-1));
        model.familyTreeSortByBirthday();
        stringBuilder.append("\n\nСортировка по дню рождения: " + model.printFamilyTree(-1,-1));
        model.familyTreeSortByName();
        stringBuilder.append("\n\nСортировка по имени: "+model.printFamilyTree(-1, -1));
        return stringBuilder.toString();
    }

    public String takePrintFamilyTree(int whom, int gendInd) {
        return model.printFamilyTree(whom, gendInd);
    }

    public String filterFamilyTree(int number) {
        return model.filterFamily(number);
    }

    public int addFamilyTree(Map<String, Object> objectMap, String objectSelection) {
        return model.addObjectInFamilyList(objectMap, objectSelection);
    }

    public List getListFields() {
        return model.getListFields();
    }

    public int takeSizeFamilyTree(int whom, int gender) {
        return model.takeSizeFamilyTree(whom, gender);
    }

    public String showRelatives(int object1, int object2) {
        return model.showRelatives(object1, object2);
    }

    public String deleteRecordFamilyTree(int object) {
        return model.deleteRecordFamilyTree(object);
    }

    public void updateObjectName(int whom, String newName) {
        model.updateObjectName(whom, newName);
    }

    public void updateObjectBirthday(int whom, String newBirthday) {
        model.updateObjectBirthday(whom, newBirthday);
    }

    public void updateObjectGender(int whom, int newGender) {
        model.updateObjectGender(whom, newGender);
    }

    public List getGenderList() {
        return model.getGenderList();
    }

    public void updateObjectParents(int whom, int parentsInd, int gender) {
        model.updateObjectParents(whom, parentsInd, gender);
    }

    public void updateObjectChildren(int whom, int childInd, int gender){
        model.updateObjectChildren(whom, childInd, gender);
    }
}
