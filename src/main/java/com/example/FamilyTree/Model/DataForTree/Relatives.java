package com.example.FamilyTree.Model.DataForTree;

import java.util.List;

public class Relatives {
    private Family object1;
    private Family object2;
    private FamilyTree<Family> familyTree;

    public Relatives(Family object1, Family object2, FamilyTree<Family> familyTree) {
        this.object1 = object1;
        this.object2 = object2;
        this.familyTree = familyTree;
    }

    public String showRelatives() {
        return comparisonParents();
    }

    private String comparisonParents() {
        if (object1.getParents().contains(object2.getObject())) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
             object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        } else if (object2.getParents().contains(object1.getObject())) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        }
        return comparisonChildren();
    }

    private String comparisonChildren() {
        if (object1.getChildren().contains(object2.getObject())) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        } else if (object2.getChildren().contains(object1.getObject())) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter " : " - son");
        }
        return comparisonSiblings();
    }

    private String comparisonSiblings() {
        if (getObjectFamilyAtParents()) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - sister " : " - brother") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - sister " : " - brother");
        }
        return comparisonSpouses();
    }

    private String comparisonSpouses() {
        if (object1.getChildren().equals(object2.getChildren()) && !object1.getChildren().isEmpty()) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother " : " - father") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother " : " - father");
        }
        return comparisonGrandFamily();
    }

    private String comparisonGrandFamily() {
        if (getObjectGrandFamily(object1, object2)) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - grandmother " : " - grandfather");
        } else if (getObjectGrandFamily(object2, object1)) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - granddaughter " : " - grandson") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - grandmother " : " - grandfather");
        }
        return comparisonGrandparents();
    }

    private String comparisonGrandparents() {
        if (getObjectFamilyAtChildren(object1.getChildren(), object2.getChildren())) {
            return object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law");
        } else if (getObjectFamilyAtChildren(object2.getChildren(), object1.getChildren())) {
            return object2.getObject() + (object2.getObject().getGender() == Gender.female ? " - mother-in-law " : " - father-in-law") + "\n" +
                    object1.getObject() + (object1.getObject().getGender() == Gender.female ? " - daughter-in-law " : " - son-in-law");
        }
        return comparisonMatchmaker();
    }

    private String comparisonMatchmaker() {
        if (getObjectFamilyAllChildren(object2.getChildren(), object1.getChildren())) {
            return object1.getObject() + " - matchmaker" + "\n" +
                    object2.getObject() + " - matchmaker";
        }
        return comparisonAunt();
    }

    private String comparisonAunt() {
        if (getObjectFamilyUncle(object1, object2)) {
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
                if (familyTree.getObjectFamily((FamilyInterface) object1.getParents().get(j)).getParents().contains(object2.getObject()) ||
                        object2.getChildren().contains(familyTree.getObjectFamily((FamilyInterface) object1.getParents().get(j)).getObject())) {
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
                if (getObjectGrandFamily(object2, familyTree.getObjectFamily((FamilyInterface) object1.getParents().get(j)))) {
                    i = true;
                }
            }
        }
        return i;
    }

    private boolean getObjectFamilyAtParents() {
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
}
