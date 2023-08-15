package family_tree.model.service;

import family_tree.model.familytree.FamilyTree;
import family_tree.model.file_methods.FileHandler;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public FamilyTree<Human> familyTree;
    public FileHandler fileHandler;
    private int id = 1;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        Human human = new Human(id++, name, birthDate, deathDate, gender);
        familyTree.addSubject(human);
    }

    public void addMother(int motherID, int childID) {
        Human humanChild = findHumanByID(childID);
        if (humanChild != null) {
            for (Human humanParent : familyTree) {
                if (humanParent.getID() == motherID) {
                    humanChild.setMother(humanParent);
                }
            }
        }
    }

    public void addFather(int fatherID, int childID) {
        Human humanChild = findHumanByID(childID);
        if (humanChild != null) {
            for (Human humanParent : familyTree){
                if(humanParent.getID() == fatherID) {
                    humanChild.setFather(humanParent);
                }
            }
        }
    }

    public List<String> getParentName(int childID) {
        List<String> parents = new ArrayList<>();
        for (Human humanChild : familyTree) {
            if(humanChild.getID() == childID) {
                if ((humanChild.getMother() != null && humanChild.getFather() != null)) {
                    parents.add("mother: " + humanChild.getMother().getName());
                    parents.add("father: " + humanChild.getFather().getName());
                }
                else if (humanChild.getMother() != null && humanChild.getFather() == null) {
                    parents.add("mother: " + humanChild.getMother().getName());
                }
                else if (humanChild.getMother() == null && humanChild.getFather() != null) {
                    parents.add("father: " + humanChild.getFather().getName());
                }
            }
        }
        return parents;
    }

    public List<String> getChildName(int id) {
        List<String> children = new ArrayList<>();
        for (Human human : familyTree) {
            if (human.getMother() != null) {
                if (id == human.getMother().getID()) {
                    children.add(human.getName());
                }
            }
            if (human.getFather() != null) {
                if (id == human.getFather().getID()) {
                    children.add(human.getName());
                }
            }
        }
        return children;
    }

    public List<String> getSiblingName(int id) {
        List<String> siblings = new ArrayList<>();
        Human human = findHumanByID(id);
        if (human != null) {
            for (Human humanSibling : familyTree) {
                if (human.getMother() != null && humanSibling.getMother() != null) {
                    if (humanSibling.getMother().getID() == human.getMother().getID()
                            && human.getID() != humanSibling.getID()
                            && !siblings.contains(human.getName())) {
                            siblings.add(humanSibling.getName());
                    }
                }
                if (human.getFather() != null && humanSibling.getFather() != null) {
                    if (humanSibling.getFather().getID() == human.getFather().getID()
                            && human.getID() != humanSibling.getID()
                            && !siblings.contains(human.getName())) {
                            siblings.add(humanSibling.getName());
                    }
                }
            }
        }
        return siblings;
    }

    public Human findHumanByID(int requiredID) {
        Human result = null;
        for (Human human : familyTree) {
            if(human.getID() == requiredID) {
                result = human;
            }
        }
        return result;
    }

    public Human findHumanByName(String requiredHuman) {
        Human result = null;
        for (Human human : familyTree) {
            if (requiredHuman.equalsIgnoreCase(human.getName())) {
                result = human;
            }
        }
        return result;
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByGender() {
        familyTree.sortByGender();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public boolean saveFile(String filePath) {
        boolean trySave;
        try {
            fileHandler.writeFamilyTree(familyTree, filePath);
            trySave = true;
        } catch (IOException e) {
            trySave = false;
        }
        return trySave;
    }

    public boolean loadFile(String filePath) {
        boolean tryLoad = true;
        Serializable loadFile;
        try {
            loadFile = fileHandler.readFamilyTree(filePath);
            familyTree = (FamilyTree<Human>) loadFile;
        } catch (IOException | ClassNotFoundException e) {
            tryLoad = false;
        }
        return tryLoad;
    }

        public String printFamilyTree() {
        StringBuilder strBuilder = new StringBuilder();
        try {
        strBuilder.append("Семейное древо:");
        strBuilder.append("\n");
        for (Human human : familyTree) {
            strBuilder.append(human);
            strBuilder.append("\n");
        }
        } catch(NullPointerException e) {
    }
        return strBuilder.toString();
    }
}
