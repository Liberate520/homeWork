package ru.medved_sa.tree_family.familyTree;

import ru.medved_sa.tree_family.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int humanId = 1;
    private final String nameFamilyTree;
    private final List<Human> humanList;

    /**
     * Конструктор создания сущности -> "Семейное дерево"
     * @param nameFamilyTree  Имя семейного дерева
     */
    public FamilyTree(String nameFamilyTree) {
        this.nameFamilyTree = nameFamilyTree;
        humanList = new ArrayList<>();
    }

    /**
     * Геттер
     * @return Вернет имя семейного дерева
     */
    public String getNameFamilyTree() {
        return nameFamilyTree;
    }

    /**
     * Метод добавления сущности Human в семейное дерево. Условие if исключает возможность добавления двух
     * одинаковых сущностей. При удачном добавлении к сущности добавляется id.
     * Методы добавления детей к родителям и родителей к детям.
     * @param human сущность добавляемого человека
     */
    public void addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);
            addChildrenToParents(human);
        }
    }

    /**
     * Метод проверяет принимаемую на вход сущность, и если внутри проверяемой сущности "активно" поле father, то
     * проверяемая, на входе в метод, сущность будет добавлена в сущность, прикрепленную к полю father,
     * добавлена как ребенок.
     * @param human Сущность, возможный потенциальный ребенок для добавления.
     */
    private void addChildrenToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    /**
     * Переопределенный метод для вывода в консоль всех сущностей хранящихся в семейном дереве.
     * @return stringBuilder
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nСемейное дерево семьи: ");
        stringBuilder.append(getNameFamilyTree());
        stringBuilder.append("\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }

}
