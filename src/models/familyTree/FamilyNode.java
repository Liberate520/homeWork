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
    private final Map<Roles, FamilyNode> upRelatives;
    private final Map<Roles, FamilyNode> childrenFamilies;

    public FamilyNode() {
        family = new HashMap<>();
        family.put(MOTHER, new ArrayList<>());
        family.put(FATHER, new ArrayList<>());
        family.put(DAUGHTER, new ArrayList<>());
        family.put(SON, new ArrayList<>());
        upRelatives = new HashMap<>();
        childrenFamilies = new HashMap<>();
    }

    public boolean findHuman(Human human) {
        for (List<Human> humanList : family.values()) {
            if (humanList.contains(human)) {
                return true;
            }
        }
        return false;
    }

    public Roles getHumanRoleOrNull(Human human) {
        for (Map.Entry<Roles, List<Human>> entities : family.entrySet()) {
            if (entities.getValue().contains(human)) {
                return entities.getKey();
            }
        }
        return null;
    }

    public boolean checkHumanRole(Human human, Roles role) {
        return family.get(role).contains(human);
    }

    public void addMember(Human human, Roles role) {
        switch (role) {
            case FATHER -> this.addFather(human);
            case MOTHER -> this.addMother(human);
            case DAUGHTER -> this.addDaughter(human);
            case SON -> this.addSon(human);
        }
    }

    public void addToUpRelatives(Roles role, FamilyNode node) {
        this.upRelatives.put(role, node);
    }

    public void delFromRelatives(Roles role, FamilyNode node) {
        this.upRelatives.remove(role, node);
    }

    public void addToChildrenFamilies(Roles role, FamilyNode node) {
        this.childrenFamilies.put(role, node);
    }

    public void delFromChildrenFamilies(Roles role, FamilyNode node) {
        this.childrenFamilies.remove(role, node);
    }

    public Map<Roles, FamilyNode> getUpRelatives() {
        return upRelatives;
    }

    public Map<Roles, FamilyNode> getChildrenFamilies() {
        return childrenFamilies;
    }

    public void delMember(Human human, Roles role) {
        switch (role) {
            case FATHER -> this.delFather();
            case MOTHER -> this.delMother();
            case DAUGHTER -> this.delDaughter(human);
            case SON -> this.delSon(human);
        }
    }

    private void addMother(Human human) {
        List<Human> list = family.get(MOTHER);
        if (list.size() == 0) {
            list.add(human);
        } else {
            list.clear();
            list.add(human);
        }
    }

    private void delMother() {
        family.get(MOTHER).clear();
    }

    private void addFather(Human human) {
        List<Human> list = family.get(FATHER);
        if (list.size() == 0) {
            list.add(human);
        } else {
            list.clear();
            list.add(human);
        }
    }

    private void delFather() {
        family.get(FATHER).clear();
    }

    private void addDaughter(Human human) {
        family.get(DAUGHTER).add(human);
    }

    private void delDaughter(Human human) {
        family.get(DAUGHTER).remove(human);
    }

    private void addSon(Human human) {
        family.get(SON).add(human);
    }

    private void delSon(Human human) {
        family.get(SON).remove(human);
    }

    public Human getMotherOrNull(){
        Human returnHuman = null;
        if (family.get(MOTHER).size() != 0) {
            returnHuman = family.get(MOTHER).get(0);
        }
        return returnHuman;
    }

    public Human getFatherOrNull(){
        Human returnHuman = null;
        if (family.get(FATHER).size() != 0) {
            returnHuman = family.get(FATHER).get(0);
        }
        return returnHuman;
    }

    public List<Human> getChildren() {
        List<Human> children = new ArrayList<>();
        children.addAll(family.get(DAUGHTER));
        children.addAll(family.get(SON));
        return children;
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        parents.addAll(family.get(FATHER));
        parents.addAll(family.get(MOTHER));
        return parents;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        family.get(FATHER).forEach(item -> builder.append(item.toString()));
        builder.append("\n");
        family.get(MOTHER).forEach(item -> builder.append(item.toString()));
        builder.append("\n");
        family.get(DAUGHTER).forEach(item -> builder.append(item.toString()));
        builder.append("\n");
        family.get(SON).forEach(item -> builder.append(item.toString()));

        return builder.toString();
    }
}
