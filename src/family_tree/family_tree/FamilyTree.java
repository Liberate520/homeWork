package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.family_tree.FamilyTreeItem;
import family_tree.human.comparators.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
// import java.util.function.Function;


public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    // private int humansId;
    private List<E> humanList;
    
    public FamilyTree(List<E> humanList) {this.humanList = humanList;}

    public FamilyTree() {this (new ArrayList<>());}
    // public FamilyTree() {humanList = new ArrayList<>();}
    // public FamilyTree(List<E> familyTree) {
    //     this.familyTree = familyTree;
    // }

    public boolean add (E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            // human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
            addToSpouse(human);
            // addToWifes(human);
            // addToHusbands(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child: human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToSpouse(E human) {
        for (E spouse: human.getSpouse()) {
            spouse.addSpouse(human);
        }
    }

    // private void addToHusbands(Human human) {
    //     for (Human spouse: human.getHusband()) {
    //         spouse.addSpouse(human);
    //     }
    // }

    // private void addToWifes(Human human) {
    //     for (Human wife: human.getWifes()) {
    //         wife.addHusbands(human);
    //     }
    // }

    // private void addToHusbands(Human human) {
    //     for (Human husband: human.getHusbands()) {
    //         husband.addWifes(human);
    //     }
    // }

    // public List<E> getSiblings(int id) {
    //     E human = getById(id);
    //     if (human == null) {return null;}

    //     List<E> res = new ArrayList<>();
    //     for (E parent: human.getParents() ) {
    //         for (E child: parent.getChildren()) {
    //             if (!child.equals(human)) {
    //                 res.add(child);
    //             }
    //         }
    //     }
    //     return res;
    // }

// public boolean setWedding(String humanName1, String humanName2) {
//     if (chekName(humanName1) && chekName(humanName2)) {
//         E human1 = getByName(humanName1);
//         E human2 = getByName(humanName2);
//         if (human1.getSpouse() == null && human2.getSpouse() == null) {
//             human1.setSpouse(human2);
//             human2.setSpouse(human1);
//         } else {return false;}
//     } 
//     return false;
// }

// public boolean setDivorse(String humanName1, String humanName2) {
//     if (chekName(humanName1) && chekName(humanName2)) {
//         E human1 = getByName(human1);
//         E human2 = getByName(human2);
//         if (human1.getSpouse() != null && human2.getSpouse() != null) {
//             human1.setSpouse(null);
//             human2.setSpouse(null);
//         } else {return false;}
//     } 
//     return false;
// }

    // private boolean chekName(String name) {
    //     if (name == null) {return false;}
    //     for (E human: humanList) {
    //         if (human.getName() == name) {return true;}
    //     }
    //     return false;
    // }

    // private boolean checkId(int id) {
    //     if (id >= humansId || id < 0) {return false;}
    //     for (E human: humanList) {
    //         if (human.getId() == id) {return true;}
    //     }
    //     return false;
    // }






// public E getById(int id) {
//     for (E human: humanList) {
//         if (human.getId() == id) {
//             return human;
//         }
//     }
//     return null;
// }


// 1 version:
    public E getByName (String name) {
        for (E human: humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }


// 2 version:
    // public List<E> getByName (String name) {
    //     List<E> res = new ArrayList<>();
    //     for (E human: humanList) {
    //         if (human.getName().equalsIgnoreCase(name)) {
    //             res.add(human);
    //         }
    //     }
    //     return res;
    // }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);}

    public void sortByName() {humanList.sort(new HumanComparatorByName<>());}
    public void sortByBirthDate() {humanList.sort(new HumanComparatorByBirthDate<>());}
}