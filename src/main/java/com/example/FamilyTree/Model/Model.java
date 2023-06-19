package com.example.FamilyTree.Model;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyTree;
import com.example.FamilyTree.Model.DataForTree.Gender;
import com.example.FamilyTree.Model.DataForTree.ObjectList.ObjectList;
import com.example.FamilyTree.Model.FileHandler.FileHandler;
import com.example.FamilyTree.Model.Printable.Printable;
import com.example.FamilyTree.Model.Printable.printObjectList;

import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Model {
    private ObjectList objectList = new ObjectList();
    private FamilyTree<Family> familyTree = new FamilyTree<>();
    private FileHandler fileHandler = new FileHandler();
    private String path;

    public List<String> getObjectList() {
        List<String> objects = objectList.getObjectList();
        objects.add(objectList.toString());
        return objects;
    }

    public void getFamilyTree(String objectSelection) {
        path = "./src/main/java/com/example/FamilyTree/FamilyTree"+objectSelection+".txt";
        File file = new File(path);
        if (!file.exists()) {
            familyTree = objectList.getFamilyTree(objectSelection);
            createFileFamilyTree();
        } else {
            familyTree = (FamilyTree<Family>) FileProcessing(2, path);
        }
    }

    public void createFileFamilyTree(){
        if (!familyEmpty()) {
            FileProcessing(1, path);
        }
    }

    public int addObjectInFamilyList(Map<String, Object> objectMap, String objectSelection) {
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
        createFileFamilyTree();
        System.out.println("добавлен элемент номер "+familyTree.getObjectFamilyList().indexOf(element));
        return familyTree.getObjectFamilyList().indexOf(element);
    }

    private Family createFamily(Map<String, Object> objectMap, String objectSelection){
        String name = (String) objectMap.get("name");
        String birthday = (String) objectMap.get("birthday");
        int numGender = (int) objectMap.get("gender");
        Gender gender = Gender.values()[numGender];
        return objectList.createFamily(objectSelection, name, birthday, gender);
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

    private Object FileProcessing(int index, String path) {
        switch (index){
            case 1: {
                fileHandler.save(path, familyTree);
                return fileHandler;
            }
            case 2: {
                return fileHandler.read(path);
            }
        }
        return null;
    }

    public String printFamilyTree(int whom, int gendInd) {
        Printable printable = new printObjectList();
        return printable.output(filterFamilyTree(whom, gendInd));
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

    public String filterFamily(int listNumber) {
        return familyTree.getObjectFamilyList().get(listNumber-1).toString();
    }

    public String deleteRecordFamilyTree(int listNumber) {
        String deleteElement = familyTree.getObjectFamilyList().get(listNumber-1).toString();
        familyTree.getObjectFamilyList().remove(listNumber-1);
        createFileFamilyTree();
        return "Запись " + deleteElement + "удалена: ";
    }

    public String showRelatives(int num1, int num2) {
        Family object1 = familyTree.getObjectFamilyList().get(num1-1);
        Family object2 = familyTree.getObjectFamilyList().get(num2-1);
        if (object1.getParents().contains(object2.getObject())) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        } else if (object2.getParents().contains(object1.getObject())) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        } else if (object1.getChildren().contains(object2.getObject())) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        } else if (object2.getChildren().contains(object1.getObject())) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        } else if (getObjectFamilyAtParents(object1,object2)) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - sister " : " - brother") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - sister " : " - brother");
        } else if (object1.getChildren().equals(object2.getChildren()) && !object1.getChildren().isEmpty()) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father");
        } else if (getObjectGrandFamily(object1, object2)) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - grandmother " : " - grandfather");
        } else if (getObjectGrandFamily(object2, object1)) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - grandmother " : " - grandfather");
        } else if (getObjectFamilyAtChildren(object1.getChildren(), object2.getChildren())) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law");
        } else if (getObjectFamilyAtChildren(object2.getChildren(), object1.getChildren())) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law");
        } else if (getObjectFamilyAllChildren(object2.getChildren(), object1.getChildren())) {
            return object1.getObject() + " - matchmaker" + "\n" +
                    object2.getObject() + " - matchmaker";
        } else if (getObjectFamilyUncle(object1, object2)) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - aunt" : " - uncle") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - niece" : " - nephew");
        } else if (getObjectFamilyUncle(object2, object1)) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - aunt" : " - uncle") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - niece" : " - nephew");
        }
        return "";
    }

    private boolean getObjectGrandFamily(Family object1, Family object2) {
        Boolean i = false;
        if (!object1.getParents().isEmpty()) {
            for (int j = 0; j < object1.getParents().size(); j++) {
                if (familyTree.getObjectFamily((Family)object1.getParents().get(j)).getParents().contains(object2.getObject()) ||
                        object2.getChildren().contains(familyTree.getObjectFamily((Family) object1.getParents().get(j)).getObject())) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyUncle(Family object1, Family object2) {
        Boolean i = false;
        if (!object1.getParents().isEmpty()) {
            for (int j = 0; j < object1.getParents().size(); j++) {
                if (getObjectGrandFamily(object2, familyTree.getObjectFamily((Family) object1.getParents().get(j)))) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyAtParents(Family object1, Family object2) {
        Boolean i = false;
        if (!object1.getParents().isEmpty() && !object2.getParents().isEmpty()) {
            if (object1.getParents().equals(object2.getParents())) {
                i = true;
            }
        } else if (!object1.getParents().isEmpty()) {
            for (int j = 0; j < object1.getParents().size(); j++) {
                if (familyTree.getObjectFamily((Family)object1.getParents().get(j)).getChildren().contains(object2.getObject())) {
                    i = true;
                }
            }
        } else if (!object2.getParents().isEmpty()) {
            for (int j = 0; j < object2.getParents().size(); j++) {
                if (familyTree.getObjectFamily((Family) object2.getParents().get(j)).getChildren().contains(object1.getObject())) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyAtChildren(List<Family> children1, List<Family> children2) {
        Boolean i = false;
        for (int j = 0; j < children1.size(); j++) {
            if (familyTree.getObjectFamily(children1.get(j)).getChildren().equals(children2)) {
                i = true;
            }
        }
        return i;
    }

    private boolean getObjectFamilyAllChildren(List<Family> children1, List<Family> children2) {
        Boolean i = false;
        for (int j = 0; j < children1.size(); j++) {
            for (int k = 0; k < children2.size(); k++) {
                if (familyTree.getObjectFamily(children1.get(j)).getChildren().equals(familyTree.getObjectFamily(children2.get(k)).getChildren())) {
                    i = true;
                }
            }
        }
        return i;
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
        createFileFamilyTree();
    }

    public void updateObjectBirthday(int whom, String birthday) {
        Date newBirthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday, new ParsePosition(0));
        familyTree.getObjectFamilyList().get(whom).getObject().setBirthday(newBirthday);
        createFileFamilyTree();
    }

    public void updateObjectGender(int whom, int gender) {
        Gender newGender = getGender(gender);
        familyTree.getObjectFamilyList().get(whom).getObject().setGender(newGender);
        createFileFamilyTree();
    }

    public void updateObjectParents(int whom, int parentsInd, int gender) {
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
        familyTree.getObjectFamilyList().get(whom).addParents(object);

        createFileFamilyTree();
        int indexParent = familyTree.getObjectFamilyList().indexOf(object);
        updateObjectChildren(indexParent, whom, -1);
    }

    public void updateObjectChildren(int whom, int childInd, int gender) {
        Family object = filterFamilyTree(whom,gender).get(childInd);
        familyTree.getObjectFamilyList().get(whom).addChildren(object);
        createFileFamilyTree();
    }

    public List getGenderList() {
        return Arrays.stream(Gender.values()).toList();
    }

    private Gender getGender(int gender){
        return Gender.values()[gender];
    }
}
