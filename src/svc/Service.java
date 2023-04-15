package svc;

import tree.FamilyTree;

import treeUnits.Human;
import treeUnits.TreeUnit;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;


public class Service<E extends TreeUnit> implements Serializable {
    private FamilyTree<E> familyTree;

    public Service(FamilyTree<E> familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        this(new FamilyTree<>());
    }

    public FamilyTree<E> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree<E> familyTree) {
        this.familyTree = familyTree;
    }

    public void addUnit(E unit) {
        familyTree.getUnits().add(unit);
        if (unit.getFather() != null) {
            unit.getFather().addChild(unit);
        }
        if (unit.getMother() != null) {
            unit.getMother().addChild(unit);
        }
    }

    public void sortHuman(Comparator<E> comp) {
        familyTree.getUnits().sort(comp);
    }

    public void save(Writable writable) throws IOException {
        writable.save(this);
    }

    public E getUnitByName(String str) {
        for (E unit : familyTree.getUnits()) {
            if (unit instanceof Human) {
                List<String> lst = List.of(str.split(" "));
                if (unit.getName().equals(lst.get(0)) && ((Human) unit).getSecondName().equals(lst.get(1)) && ((Human) unit).getSurname().equals(lst.get(2))) {
                    return unit;
                }
            } else {
                if (unit.getName().equals(str)) {
                    return unit;
                }
            }
        }
        return null;
    }
}
