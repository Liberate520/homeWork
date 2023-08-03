import models.Human;
import models.Roles;
import models.familyTree.FamilyNode;
import models.familyTree.FamilyTree;

import java.util.List;

import static models.Roles.*;

// Сервис для работы с семейным древом.
public class FamilyService {
    private final FamilyTree familyTree;

    public FamilyService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    /**
     * Создание новой ячейки семьи для переданного Human и добавление в структуру дерева.
     *
     * @param human объект для которого создаётся семья.
     * @return созданная семья.
     */
    public FamilyNode createNewFamily(Human human) {
        FamilyNode newFamily = new FamilyNode();
        switch (human.gender()) {
            case MALE -> newFamily.addMember(human, FATHER);
            case FEMALE -> newFamily.addMember(human, MOTHER);
        }
        this.familyTree.addNode(newFamily);
        return newFamily;
    }

    /**
     * Проверка на наличие семьи в структуре.
     *
     * @param node ячейка для поиска.
     * @return
     */
    public boolean containsFamily(FamilyNode node) {
        return this.familyTree.contain(node);
    }

    /**
     * Удаление ячейки семьи конкретного Human из структуры.
     *
     * @param human объект для поиска и удаления ячейки.
     */
    public void deleteFamily(Human human) {
        FamilyNode family = this.findPrimaryFamilyOrNull(human);
        if (family != null) {
            familyTree.delNode(family);
        } else throw new RuntimeException("Family not found!");
    }

    /**
     * Добавление нового члена в семью.
     *
     * @param human      к кому в семью добавлять.
     * @param humanToAdd кого добавлять в семью.
     * @param role
     */
    public void addMemberToFamily(Human human, Human humanToAdd, Roles role) {
        FamilyNode node = this.findPrimaryFamilyOrNull(human);
        if (node != null) {
            node.addMember(humanToAdd, role);
        } else throw new RuntimeException("Primary Family not found for " + human);

        FamilyNode nodeToAdd = this.findPrimaryFamilyOrNull(humanToAdd);
        if (nodeToAdd == null) {
            nodeToAdd = this.createNewFamily(humanToAdd);
        }

        this.updateFamilyNodesAdd(node, nodeToAdd, role);
    }

    private void updateFamilyNodesAdd(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        switch (role) {
            case FATHER -> this.setUpRelatives(targetNode, nodeToAdd, FATHER);
            case MOTHER -> this.setUpRelatives(targetNode, nodeToAdd, MOTHER);
            case DAUGHTER -> this.setRelativesToChildren(targetNode, nodeToAdd, DAUGHTER);
            case SON -> this.setRelativesToChildren(targetNode, nodeToAdd, SON);
        }
    }

    private void setUpRelatives(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        FamilyNode parentNode = null;
        switch (role) {
            case FATHER -> parentNode = this.findPrimaryFamilyOrNull(nodeToAdd.getFatherOrNull());
            case MOTHER -> parentNode = this.findPrimaryFamilyOrNull(nodeToAdd.getMotherOrNull());
        }
        if (parentNode != null && !parentNode.getUpRelatives().isEmpty()) {
            targetNode.addToUpRelatives(role, parentNode);
        }
    }

    private void setRelativesToChildren(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        targetNode.addToChildrenFamilies(role, nodeToAdd);

        FamilyNode fatherNode = this.findPrimaryFamilyOrNull(targetNode.getFatherOrNull());
        FamilyNode motherNode = this.findPrimaryFamilyOrNull(targetNode.getMotherOrNull());

        nodeToAdd.addToUpRelatives(FATHER, fatherNode);
        nodeToAdd.addToUpRelatives(MOTHER, motherNode);
    }

    /**
     * Удаление члена из семьи.
     *
     * @param human      у кого виз семьи удалять.
     * @param humanToDel кого удалять из семьи.
     * @param role
     */
    public void delMemberFromFamily(Human human, Human humanToDel, Roles role) {
        FamilyNode node = this.findPrimaryFamilyOrNull(human);
        if (node != null) {
            node.delMember(humanToDel, role);
        } else throw new RuntimeException("Primary family not found for " + human);

        FamilyNode nodeToExclude = this.findPrimaryFamilyOrNull(humanToDel);

        if (nodeToExclude != null) {
            this.updateFamilyNodesDel(node, nodeToExclude, role);
        }
    }

    private void updateFamilyNodesDel(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        switch (role) {
            case FATHER -> targetNode.delFromRelatives(FATHER, nodeToAdd);
            case MOTHER -> targetNode.delFromRelatives(MOTHER, nodeToAdd);
            case DAUGHTER -> targetNode.delFromChildrenFamilies(DAUGHTER, nodeToAdd);
            case SON -> targetNode.delFromChildrenFamilies(SON, nodeToAdd);
        }
    }

    /**
     * Вывод в консоль семьи.
     *
     * @param human чью семью выводить.
     */
    public void printPrimaryFamily(Human human) {
        System.out.println(this.findPrimaryFamilyOrNull(human).toString());
    }

    private FamilyNode findPrimaryFamilyOrNull(Human human) {
        FamilyNode node = null;
        switch (human.gender()) {
            case MALE -> node = familyTree.findFamilyOrNull(human, FATHER);
            case FEMALE -> node = familyTree.findFamilyOrNull(human, MOTHER);
        }
        return node;
    }

    /**
     * Получить детей из семьи указанного Human.
     *
     * @param human объект для поиска семьи.
     * @return список детей.
     */
    public List<Human> getChildren(Human human) {
        FamilyNode family = this.findPrimaryFamilyOrNull(human);
        return family.getChildren();
    }

    /**
     * Получить родителей из семьи указанного Human.
     *
     * @param human объект для поиска семьи.
     * @return список родителей.
     */
    public List<Human> getParents(Human human) {
        FamilyNode family = this.findPrimaryFamilyOrNull(human);
        return family.getParents();
    }
}
