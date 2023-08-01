package models.familyTree;

import models.Human;
import models.Roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.Roles.*;

public class FamilyNode {
    private final Map<Roles, List<Human>> family;


    FamilyNode() {
        family = new HashMap<>();
        family.put(MOTHER, new ArrayList<>());
        family.put(FATHER, new ArrayList<>());
        family.put(DAUGHTER, new ArrayList<>());
        family.put(SON, new ArrayList<>());
    }

    boolean findHuman(Human human) {
        for (List<Human> humanList : family.values()) {
            if (humanList.contains(human)) {
                return true;
            }
        }
        return false;
    }

    void addMother(Human human) {
        List<Human> list = family.get(MOTHER);
        if (list.size() == 0) {
            list.add(human);
        } else {
            list.clear();
            list.add(human);
        }
    }

    void delMother() {
        family.get(MOTHER).clear();
    }


    void addFather(Human human) {
        List<Human> list = family.get(FATHER);
        if (list.size() == 0) {
            list.add(human);
        } else {
            list.clear();
            list.add(human);
        }
    }

    void delFather() {
        family.get(FATHER).clear();
    }

    void addDaughter(Human human) {
        family.get(DAUGHTER).add(human);
    }

    void delDaughter(Human human) {
        family.get(DAUGHTER).remove(human);
    }


    void addSon(Human human) {
        family.get(SON).add(human);
    }

    void delSon(Human human) {
        family.get(SON).remove(human);
    }

    Human getMother() {
        return family.get(MOTHER).get(0);
    }

    Human getFather() {
        return family.get(FATHER).get(0);
    }

    List<Human> getChildren() {
        List<Human> children = new ArrayList<>();
        children.addAll(family.get(DAUGHTER));
        children.addAll(family.get(SON));
        return children;
    }
}
