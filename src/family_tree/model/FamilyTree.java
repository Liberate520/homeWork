package family_tree.model;

import family_tree.model.comparators.ComparatorByAge;
import family_tree.model.comparators.ComparatorByGender;
import family_tree.model.comparators.ComparatorByName;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FamilyTree<E extends Subject<E>> implements Serializable {
    private List<E> familyTree;
    private int id = 1;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        E human = (E) new Human(id++, name, birthDate, deathDate, gender);
        familyTree.add(human);
    }

    public void addMother(int motherID, int childID) {
        E humanChild = findHumanByID(childID);
            if (humanChild != null) {
                for (E humanParent : familyTree) {
                    if (humanParent.getID() == motherID) {
                        humanChild.setMother(humanParent);
                    }
                }
            }
        }

    public void addFather(int fatherID, int childID) {
        E humanChild = findHumanByID(childID);
            if (humanChild != null) {
                for (E humanParent : familyTree){
                    if(humanParent.getID() == fatherID) {
                        humanChild.setFather(humanParent);
                    }
                }
            }
        }

    public List<String> getParentName(int childID) {
        List<String> parents = new ArrayList<>();
        for (E humanChild : familyTree) {
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
        for (E human : familyTree) {
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
        E human = findHumanByID(id);
            if (human != null) {
                try {
                    for (E humanSibling : familyTree) {
                        if (human.getMother() != null && humanSibling.getMother() != null) {
                            if (humanSibling.getMother().getID() == human.getMother().getID()
                                    && human.getID() != humanSibling.getID()
                                    && !siblings.contains(human.getName())) {
                                siblings.add(humanSibling.getName());
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
                } catch (NullPointerException e) {
                }
            }
            return siblings;
        }

    public E findHumanByID(int requiredID) {
        E result = null;
        for (E human : familyTree) {
            if(human.getID() == requiredID) {
                result = human;
            }
        }
        return result;
    }

    public E findHumanByName(String requiredHuman) {
        E result = null;
        for (E human : familyTree) {
            if (requiredHuman.equalsIgnoreCase(human.getName())) {
                result = human;
            } 
        }
        return result;
    }

    public void sortByAge() {
        familyTree.sort(new ComparatorByAge<>());
    }

    public void sortByGender() {
        familyTree.sort(new ComparatorByGender<>());
    }

    public void sortByName() {
        familyTree.sort(new ComparatorByName<>());
    }

    public String printFamilyTree() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Семейное древо:");
        strBuilder.append("\n");
        for (E human : familyTree) {
            strBuilder.append(human);
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}