package com.example.FamilyTree.Model;

import com.example.FamilyTree.DataForTree.Family;
import com.example.FamilyTree.DataForTree.FamilyInterface;
import com.example.FamilyTree.DataForTree.FamilyTree;
import com.example.FamilyTree.DataForTree.Gender;
import com.example.FamilyTree.DataForTree.ObjectList.ObjectList;
import com.example.FamilyTree.Model.FileHandler.FileHandler;
import com.example.FamilyTree.Model.Printable.Printable;
import com.example.FamilyTree.Model.Printable.printObjectList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private ObjectList objectList = new ObjectList();

    public FamilyTree<Family> getFamilyTree(String objectSelection, String path) {
        FamilyTree<Family> familyTree = objectList.getFamilyTree(objectSelection);
        return familyTree;
    }

    public Object FileProcessing(int index, FamilyTree<Family> familyTree, String path) {
        FileHandler fileHandler = new FileHandler();
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

    public String printFamilyTree(FamilyTree<Family> familyTree){
        Printable printable = new printObjectList();
        return printable.output(familyTree);
    }

    public void filterFamilyTree(String answer, FamilyTree<Family> familyTree) {
        List<Integer> listNumber = Arrays.stream(answer.split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        int allObject = familyTree.getObjectFamilyList().size();
        if (listNumber.size()==1 && listNumber.get(0)<=allObject){
            System.out.println(familyTree.getObjectFamilyList().get(listNumber.get(0)-1));
        } else if (listNumber.size()==2 && listNumber.get(0)<=allObject && listNumber.get(1)<=allObject){
            showRelatives(familyTree.getObjectFamilyList().get(listNumber.get(0)-1), familyTree.getObjectFamilyList().get(listNumber.get(1)-1), familyTree);
        } else {
            System.out.println("Ошибка ввода, попробуйте снова");
        }
    }

    private void showRelatives(Family object1, Family object2, FamilyTree familyTree) {
        if (object1.getParents().contains(object2.getObject())) {
            System.out.println(object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (object2.getParents().contains(object1.getObject())) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (object1.getChildren().contains(object2.getObject())) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (object2.getChildren().contains(object1.getObject())) {
            System.out.println(object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter " : " - son"));
        } else if (getObjectFamilyAtParents(object1,object2,familyTree)) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - sister " : " - brother") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - sister " : " - brother"));
        } else if (object1.getChildren().equals(object2.getChildren()) && !object1.getChildren().isEmpty()) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father"));
        } else if (getObjectGrandFamily(object1, object2, familyTree)) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - grandmother " : " - grandfather"));
        } else if (getObjectGrandFamily(object2, object1, familyTree)) {
            System.out.println(object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - grandmother " : " - grandfather"));
        } else if (getObjectFamilyAtChildren(object1.getChildren(), object2.getChildren(), familyTree)) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law"));
        } else if (getObjectFamilyAtChildren(object2.getChildren(), object1.getChildren(), familyTree)) {
            System.out.println(object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law"));
        } else if (getObjectFamilyAllChildren(object2.getChildren(), object1.getChildren(), familyTree)) {
            System.out.println(object1.getObject() + " - matchmaker" + "\n" +
                    object2.getObject() + " - matchmaker");
        } else if (getObjectFamilyUncle(object1, object2, familyTree)) {
            System.out.println(object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - aunt" : " - uncle") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - niece" : " - nephew"));
        } else if (getObjectFamilyUncle(object2, object1, familyTree)) {
            System.out.println(object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - aunt" : " - uncle") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - niece" : " - nephew"));
        }
    }

    private boolean getObjectGrandFamily(Family object1, Family object2, FamilyTree familyTree) {
        Boolean i = false;
        if (!object1.getParents().isEmpty()) {
            for (int j = 0; j < object1.getParents().size(); j++) {
                if (familyTree.getObjectFamily((FamilyInterface)object1.getParents().get(j)).getParents().contains(object2.getObject()) ||
                        object2.getChildren().contains(familyTree.getObjectFamily((FamilyInterface) object1.getParents().get(j)).getObject())) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyUncle(Family object1, Family object2, FamilyTree familyTree) {
        Boolean i = false;
        if (!object1.getParents().isEmpty()) {
            for (int j = 0; j < object1.getParents().size(); j++) {
                if (getObjectGrandFamily(object2, familyTree.getObjectFamily((FamilyInterface) object1.getParents().get(j)), familyTree)) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyAtParents(Family object1, Family object2, FamilyTree familyTree) {
        Boolean i = false;
        if (!object1.getParents().isEmpty() && !object2.getParents().isEmpty()) {
            if (object1.getParents().equals(object2.getParents())) {
                i = true;
            }
        } else if (!object1.getParents().isEmpty()) {
            for (int j = 0; j < object1.getParents().size(); j++) {
                if (familyTree.getObjectFamily((FamilyInterface) object1.getParents().get(j)).getChildren().contains(object2.getObject())) {
                    i = true;
                }
            }
        } else if (!object2.getParents().isEmpty()) {
            for (int j = 0; j < object2.getParents().size(); j++) {
                if (familyTree.getObjectFamily((FamilyInterface) object2.getParents().get(j)).getChildren().contains(object1.getObject())) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyAtChildren(List<FamilyInterface> children1, List<FamilyInterface> children2, FamilyTree familyTree) {
        Boolean i = false;
        for (int j = 0; j < children1.size(); j++) {
            if (familyTree.getObjectFamily(children1.get(j)).getChildren().equals(children2)) {
                i = true;
            }
        }
        return i;
    }

    private boolean getObjectFamilyAllChildren(List<FamilyInterface> children1, List<FamilyInterface> children2, FamilyTree familyTree) {
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

}
