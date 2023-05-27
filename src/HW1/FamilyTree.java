package HW1;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;


    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    /**
     * Добавляет связь ребенка и родителя. После выполнения у родителя и ребенка в классе появится необходимая ветвь.
     *
     * @param parent родитель
     * @param child ребенок
     */
    public void addBranchParentChild(Human parent, Human child) {
        if (child.getFather() == null) {
            child.setFather(parent);
            if (!checkChildByName(parent, child)) {
                parent.addChild(child);
            }
        } else {
            child.setMother(parent);
            if (!checkChildByName(parent, child)) {
                parent.addChild(child);
            }
        }
    }

    /**
     * Проверяет есть ли ребенок с переданным именем, в списке детей класса Human
     *
     * @param parent родитель
     * @param child ребенок
     * @return true or false
     */
    private boolean checkChildByName(Human parent, Human child) {
        for (Human child_ : parent.getChildren()
        ) {
            if (child_.getName().equalsIgnoreCase(child.getName())) return true;
        }
        return false;
    }

    /**
     * Для добавления человека в семейное древо без родителей.
     * Так же метод добавляет ребенка родителю
     *
     * @param person человек
     */
    public void addPersonInFamilyTree(Human person) {
        familyTree.add(person);
    }

    /**
     * Для добавления человека в семейное древо с одним предком.
     * Так же метод добавляет ребенка родителю
     *
     * @param child ребенок
     * @param parent родитель
     */
    public void addPersonInFamilyTree(Human child, String parent) {
        addBranchParentChild(getPerson(parent), child);
        familyTree.add(child);
    }

    /**
     * Для добавления человека в семейное древо с двумя родителями.
     * Так же метод добавляет ребенка родителю
     *
     * @param child ребенок
     * @param fatherName имя отца
     * @param motherName имя матери
     */
    public void addPersonInFamilyTree(Human child, String fatherName, String motherName) {
        addBranchParentChild(getPerson(fatherName), child);
        addBranchParentChild(getPerson(motherName), child);
        familyTree.add(child);
    }

    /**
     * Возвращает человека из списка древа
     * @param person человек
     * @return Human
     */
    public Human getPerson(String person) {
        for (Human person_ : familyTree
        ) {
            if (person_.getName().equals(person)) return person_;
        }
        return null;
    }

    /**
     * Для вывода родителей
     */
    public void showParents(String childName) {
        Human father = getPerson(childName).getFather();
        Human mother = getPerson(childName).getMother();
        System.out.println(
                "-> родитель: " + ((father != null) ? father.getName() : "unknown") + " + " +
                        "родитель: " + ((mother != null) ? mother.getName() : "unknown") + " -> ребенок: " + childName);
    }

    /**
     * Метод для отображения всех детей человека
     */
    public void showChildren(String childName) {
        List<Human> children = getPerson(childName).children;
        if (!children.isEmpty()) {
            System.out.print("-> родитель: " + childName);

            System.out.print(" -> Дети: ");
            for (Human child : children) {
                System.out.printf("%s%s ", "\u00B7",  child.getName());
            }
            System.out.println();
        } else {
            System.out.printf("%s не имеет детей.", childName);
        }
    }
}
