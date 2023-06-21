package com.example.FamilyTree.Presenter;

import com.example.FamilyTree.Model.Model;
import com.example.FamilyTree.View.Printable.Printable;

import java.util.List;
import java.util.Map;

public class Presenter {
    private Model model;

    public Presenter(Printable printable) {
        model = new Model(printable);
    }

    public List<String> getObjectList() {
        return model.getObjectList();
    }

    public boolean runFamilyTree(int objectSelection) {
        model.getFamilyTree(objectSelection);
        return !model.familyEmpty();
    }

    public String showFamilyTree(int number) {
        return model.showFamilyTree(number);
    }

    public int addFamilyTree(Map<String, Object> objectMap, int objectSelection) {
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

    public void updateObjectParents(int whom, int parentsInd, int gender, boolean flag) {
        model.updateObjectParents(whom, parentsInd, gender, flag);
    }

    public void updateObjectChildren(int whom, int childInd, int gender, boolean flag){
        model.updateObjectChildren(whom, childInd, gender, flag);
    }

    public void familyTreeSortByBirthday() {
        model.familyTreeSortByBirthday();
    }

    public void familyTreeSortByName() {
        model.familyTreeSortByName();
    }

    public String printFamilyTree(int whom, int gendInd) {
        return model.printFamilyTree(whom, gendInd);
    }
}
