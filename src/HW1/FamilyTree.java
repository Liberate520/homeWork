package HW1;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    /**
     * Добавляет связь ребенка и родителя. После выполнения у родителя и ребенка в классе появится необходимая ветвь.
     *
     * @param parent родитель
     * @param child  ребенок
     */
    public void addBranchParentChild(Human parent, Human child) {
        if (parent != null) {
            if (parent.getSex().equalsIgnoreCase("man")) {
                child.setFather(parent);
                addChildBranch(parent, child);
            } else if (parent.getSex().equalsIgnoreCase("woman")) {
                child.setMother(parent);
                addChildBranch(parent, child);
            }
        }
    }


    /**
     * Проверяет есть ли у родителя нужный ребенок, если нет, добавляет его в список.
     *
     * @param parent
     * @param child
     */
    private void addChildBranch(Human parent, Human child) {
        if (!parent.getChildren().contains(child)) {
            parent.addChild((child));
        }
    }

    /**
     * Для добавления человека в семейное древо без родителей.
     * Так же метод добавляет ребенка родителю
     *
     * @param person человек
     */
    public void addPersonInFamilyTree(Human person) {
        if (!checkPersonInTree(person)) familyTree.add(person);
    }

    /**
     * Для добавления человека в семейное древо с одним предком.
     * Так же метод добавляет ребенка родителю
     *
     * @param person ребенок
     * @param parent родитель
     */
    public void addPersonInFamilyTree(Human person, String parent) {
        if (!checkPersonInTree(person)) {
            addBranchParentChild(getPersonFromTreeByName(parent), person);
            familyTree.add(person);
        }

        //TODO лучше пользоваться уже написанным методом addPersonInFamilyTree. Например в этом
        // методе могла бы быть проверка на то, что такого человека еще нет в дереве
    }

    /**
     * Для добавления человека в семейное древо с двумя родителями.
     * Так же метод добавляет ребенка родителю
     *
     * @param child      ребенок
     * @param fatherName имя отца
     * @param motherName имя матери
     */
    public void addPersonInFamilyTree(Human child, String fatherName, String motherName) {
        if (checkPersonInTree(child)) {
            addBranchParentChild(getPersonFromTreeByName(motherName), child);
            addBranchParentChild(getPersonFromTreeByName(fatherName), child);
            familyTree.add(child);
        }
    }

    /**
     * Возвращает человека из списка древа
     *
     * @param person человек
     * @return Human
     */
    public Human getPersonFromTreeByName(String person) {
        for (Human person_ : familyTree
        ) {
            if (person_.getNAME().equalsIgnoreCase(person)) return person_;
        }
        return null;
    }

    private boolean checkPersonInTree(Human person) {
        return familyTree.contains(person);
    }

    //TODO На самом деле лучше писать класс в режиме Api и просто возвращать результат работы, а не выводить его в
    // консоль. Ведь возможно потом нужно будет инфу выводить не в консоль, а например на страницу веб приложения

    /**
     * Для вывода родителей
     */
    public void showParents(String childName) {
        Human child = getPersonFromTreeByName(childName);
        if (child != null) {
            Human father = child.getFather();
            Human mother = child.getMother();
            System.out.println(
                    "-> родитель: " + ((father != null) ? father.getNAME() : "unknown") + " + " +
                            "родитель: " + ((mother != null) ? mother.getNAME() : "unknown") + " -> ребенок: " + childName);
        } else {
            System.out.println(childName + " не найден в семейном древе.");
        }
    }

    /**
     * Метод для отображения всех детей человека
     */
    public void showChildren(String parentName) {
        try {
            List<Human> children = getPersonFromTreeByName(parentName).getChildren();
            if (!children.isEmpty()) {
                System.out.print("-> родитель: " + parentName);

                System.out.print(" -> Дети: ");
                for (Human child : children) {
                    System.out.printf("%s%s ", "·", child.getNAME());
                }
                System.out.println();
            } else {
                System.out.printf("%s не имеет детей.", parentName);
            }
        } catch (NullPointerException e) {
            System.out.println("-> ERROR. Проверьте правильность написания имени родителя '" + parentName + "'");
        }
    }
}
