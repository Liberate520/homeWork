package models.familyTree;

import models.Human;
import models.Roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.Roles.*;

/**
 * Ячейка для хранения семьи.
 * Содержит ссылки на ячейки семей старших родственников и детей.
 */
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

    /**
     * Проверка на присутствия Human в семье.
     * @param human объект для проверки.
     * @return
     */
    public boolean findHuman(Human human) {
        for (List<Human> humanList : family.values()) {
            if (humanList.contains(human)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает роль Human в семье, если таковой присутствует.
     * @param human объект для проверки.
     * @return
     */
    public Roles getHumanRoleOrNull(Human human) {
        for (Map.Entry<Roles, List<Human>> entities : family.entrySet()) {
            if (entities.getValue().contains(human)) {
                return entities.getKey();
            }
        }
        return null;
    }

    /**
     * Проверка на присутствие в семье определённого Human с определённой ролью.
     * @param human объект для поиска.
     * @param role роль для поиска
     * @return соответствие всем параметрам поиска
     */
    public boolean checkHumanRole(Human human, Roles role) {
        return family.get(role).contains(human);
    }

    /**
     * Добавляет Human в семью.
     * @param human новый Human.
     * @param role роль для нового Human.
     */
    public void addMember(Human human, Roles role) {
        switch (role) {
            case FATHER -> this.addFather(human);
            case MOTHER -> this.addMother(human);
            case DAUGHTER -> this.addDaughter(human);
            case SON -> this.addSon(human);
        }
    }

    /**
     * Удаляет Human из семьи.
     * @param human Human для удаления.
     * @param role роль удаляемого Human.
     */
    public void delMember(Human human, Roles role) {
        switch (role) {
            case FATHER -> this.delFather();
            case MOTHER -> this.delMother();
            case DAUGHTER -> this.delDaughter(human);
            case SON -> this.delSon(human);
        }
    }

    /**
     * Добавить ячейку старших родственников.
     * @param role исходная роль родителя, чьи старшие родители добавляются.
     * @param node ячейка с родителями.
     */
    public void addToUpRelatives(Roles role, FamilyNode node) {
        this.upRelatives.put(role, node);
    }

    /**
     * Удалить ячейку старших родственников.
     * @param role исходная роль родителя, чьи старшие родители убираются.
     * @param node ячейка с родителями.
     */
    public void delFromRelatives(Roles role, FamilyNode node) {
        this.upRelatives.remove(role, node);
    }

    /**
     * Добавить ячейку детей.
     * @param role исходная роль ребёнка, чья ячейка добавляется.
     * @param node ячейка ребёнка.
     */
    public void addToChildrenFamilies(Roles role, FamilyNode node) {
        this.childrenFamilies.put(role, node);
    }

    /**
     * Удалить ячейку детей.
     * @param role исходная роль ребёнка, чья ячейка убирается.
     * @param node ячейка ребёнка.
     */
    public void delFromChildrenFamilies(Roles role, FamilyNode node) {
        this.childrenFamilies.remove(role, node);
    }

    /**
     * Возвращает ячейки старших родственников.
     * @return
     */
    public Map<Roles, FamilyNode> getUpRelatives() {
        return upRelatives;
    }

    /**
     * Возвращает ячейки детей.
     * @return
     */
    public Map<Roles, FamilyNode> getChildrenFamilies() {
        return childrenFamilies;
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

    /**
     * Возвращает мать из семьи или null при её отсутствии.
     * @return Human или Null.
     */
    public Human getMotherOrNull(){
        Human returnHuman = null;
        if (family.get(MOTHER).size() != 0) {
            returnHuman = family.get(MOTHER).get(0);
        }
        return returnHuman;
    }

    /**
     * Возвращает отца из семьи или null при его отсутствии.
     * @return Human или Null.
     */
    public Human getFatherOrNull(){
        Human returnHuman = null;
        if (family.get(FATHER).size() != 0) {
            returnHuman = family.get(FATHER).get(0);
        }
        return returnHuman;
    }

    /**
     * Возвращает список с детьми из семьи.
     * @return
     */
    public List<Human> getChildren() {
        List<Human> children = new ArrayList<>();
        children.addAll(family.get(DAUGHTER));
        children.addAll(family.get(SON));
        return children;
    }

    /**
     * Возвращает список с родителями из семьи.
     * @return
     */
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
