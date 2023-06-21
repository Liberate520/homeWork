package com.example.FamilyTree.Model;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyTree;
import com.example.FamilyTree.Model.DataForTree.Gender;
import com.example.FamilyTree.Model.DataForTree.ObjectList.ObjectList;
import com.example.FamilyTree.Model.DataForTree.ObjectList.ObjectListInterface;
import com.example.FamilyTree.Model.DataForTree.Relatives;
import com.example.FamilyTree.Model.FileHandler.FileHandler;
import com.example.FamilyTree.View.Printable.Printable;

import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Model {
    private ObjectListInterface objectList = new ObjectList();
    private FamilyTree<Family> familyTree = new FamilyTree<>();
    private FileHandler fileHandler = new FileHandler();
    private Printable printable;

    private String path;


    public Model(Printable printable) {
        this.printable = printable;
    }

    public List<String> getObjectList() {
        return objectList.getObjectList();
    }

    public void getFamilyTree(int objectSelection) {
        path = "./src/main/java/com/example/FamilyTree/FamilyTree"+getObjectList().get(objectSelection)+".txt";
        File file = new File(path);
        if (!file.exists()) {
            familyTree = objectList.getFamilyTree(objectSelection);
            fileSave();
        } else {
            familyTree = (FamilyTree<Family>) fileRead(path);
        }
    }

    private void fileSave(){
        if (!familyEmpty()) {
            fileHandler.save(path, familyTree);
        }
    }

    private Object fileRead(String path) {
        return fileHandler.read(path);
    }

    public int addObjectInFamilyList(Map<String, Object> objectMap, int objectSelection) {
        Family element = createFamily(objectMap, objectSelection);
        objectMap.remove("name");
        objectMap.remove("birthday");
        objectMap.remove("gender");
        if (objectMap.containsKey("parent1")) {
            element.addParents(familyTree.getObjectFamilyList().get((int) objectMap.get("parent1")));
            objectMap.remove("parent1");
        }
        if (objectMap.containsKey("parent0")) {
            element.addParents(familyTree.getObjectFamilyList().get((int) objectMap.get("parent0")));
            objectMap.remove("parent0");
        }
        if (objectMap.containsKey("child")) {
            element.addChildren(familyTree.getObjectFamilyList().get((int) objectMap.get("child")));
        }
        familyTree.addObjectFamilyList(element);
        fileSave();
        return familyTree.getObjectFamilyList().indexOf(element);
    }

    private Family createFamily(Map<String, Object> objectMap, int objectSelection){
        String name = (String) objectMap.get("name");
        String birthday = (String) objectMap.get("birthday");
        int numGender = (int) objectMap.get("gender");
        Gender gender = Gender.values()[numGender];
        return objectList.getNewObject(objectSelection, name, birthday, gender);
    }

    public boolean familyEmpty(){
        return familyTree.getObjectFamilyList().isEmpty();
    }

    public void familyTreeSortByBirthday(){
        familyTree.sortByBirthday();
    }

    public void familyTreeSortByName(){
        familyTree.sortByName();
    }

    public int takeSizeFamilyTree(int whom, int gender){
        return filterFamilyTree(whom, gender).size();
    }

    private List<Family> filterFamilyTree(int whom, int gendInd){
        return (whom==-1 && gendInd==-1) ? familyTree.getObjectFamilyList() :
                ((gendInd==-1) ? familyTree.getFilterObject(family -> family!=familyTree.getObjectFamilyList().get(whom))
                :((whom==-1) ? familyTree.getFilterObject(family -> family.getGender()==getGender(gendInd))
                : familyTree.getFilterObject(family -> family!=familyTree.getObjectFamilyList().get(whom) && family.getGender()==getGender(gendInd))));
    }

    public String showFamilyTree(int listNumber) {
        return familyTree.getObjectFamilyList().get(listNumber-1).toString();
    }

    public String deleteRecordFamilyTree(int listNumber) {
        String deleteElement = familyTree.getObjectFamilyList().get(listNumber-1).toString();
        familyTree.getObjectFamilyList().remove(listNumber-1);
        fileSave();
        return "Запись " + deleteElement + "удалена: ";
    }

    public String showRelatives(int num1, int num2) {
        Family object1 = familyTree.getObjectFamilyList().get(num1);
        Family object2 = familyTree.getObjectFamilyList().get(num2);
        Relatives relatives = new Relatives(object1, object2, familyTree);
        return relatives.showRelatives();
    }

    public List getListFields() {
        /*List<String> fields = new ArrayList<>();
        Field[] fieldObject = familyTree.getObjectFamilyList().get(0).getObject().getClass().getSuperclass().getDeclaredFields();
        for(int i = 0; i < fieldObject.length; i++) {
            fields.add(fieldObject[i].getName());
        }
        fieldObject = familyTree.getObjectFamilyList().get(0).getClass().getDeclaredFields();
        for(int i = 0; i < fieldObject.length; i++) {
            fields.add(fieldObject[i].getName());
        }*/
        return familyTree.getObjectFamilyList().get(0).getListFields();
    }

    public void updateObjectName(int whom, String newName) {
        familyTree.getObjectFamilyList().get(whom).getObject().setName(newName);
        fileSave();
    }

    public void updateObjectBirthday(int whom, String birthday) {
        Date newBirthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday, new ParsePosition(0));
        familyTree.getObjectFamilyList().get(whom).getObject().setBirthday(newBirthday);
        fileSave();
    }

    public void updateObjectGender(int whom, int gender) {
        Gender newGender = getGender(gender);
        familyTree.getObjectFamilyList().get(whom).getObject().setGender(newGender);
        fileSave();
    }

    public void updateObjectParents(int whom, int parentsInd, int gender, boolean flag) {
        Family object = filterFamilyTree(whom,gender).get(parentsInd);
        List parent= familyTree.getObjectFamilyList().get(whom).getParents();
        int index = -1;
        for (int i = 0; i < parent.size(); i++) {
            if (familyTree.getObjectFamilyList().get(whom).getFilterParents(p -> p.getGender()==getGender(gender)).contains(parent.get(i))) {
                index = i;
            }
        }
        if (index!=-1){
            familyTree.getObjectFamilyList().get(whom).getParents().remove(index);
        }
        if (familyTree.getObjectFamilyList().get(whom).addParents(object.getObject())) {
            fileSave();
            if (flag) {
                int indexParent = familyTree.getObjectFamilyList().indexOf(object);
                int indexChild = filterFamilyTree(indexParent, -1).indexOf(familyTree.getObjectFamilyList().get(whom));
                updateObjectChildren(indexParent, indexChild, -1, false);
            }
        }
    }

    public void updateObjectChildren(int whom, int childInd, int gender, boolean flag) {
        Family object = filterFamilyTree(whom,gender).get(childInd);
        if (familyTree.getObjectFamilyList().get(whom).addChildren(object.getObject())) {
            fileSave();
            if (flag) {
                int indexChild = familyTree.getObjectFamilyList().indexOf(object);
                int indexGenderParent = getGenderList().indexOf(familyTree.getObjectFamilyList().get(whom).getObject().getGender());
                int indexParent = filterFamilyTree(indexChild, indexGenderParent).indexOf(familyTree.getObjectFamilyList().get(whom));
                updateObjectParents(indexChild, indexParent, indexGenderParent, false);
            }
        }
    }

    public List getGenderList() {
        return Arrays.stream(Gender.values()).toList();
    }

    private Gender getGender(int gender){
        return Gender.values()[gender];
    }

    public String printFamilyTree(int whom, int gendInd) {
        return printable.output(filterFamilyTree(whom, gendInd));
    }
}
