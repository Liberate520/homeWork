package HW1;

import java.time.Year;
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
            }
            if (parent.getSex().equalsIgnoreCase("woman")) {
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
    public void addPersonInFamilyTree(Human person, String parent, int yearOfBirth) {
        if (!checkPersonInTree(person)) {
            addBranchParentChild(getPersonFromTree(parent, yearOfBirth), person);
            familyTree.add(person);
        }
    }

    /**
     * Для добавления человека в семейное древо с двумя родителями.
     * Так же метод добавляет ребенка родителю
     *
     * @param child      ребенок
     * @param fatherName имя отца
     * @param motherName имя матери
     */
    public void addPersonInFamilyTree(Human child,
                                      String fatherName, int yearOfBirthFather,
                                      String motherName, int yearOfBirthMother) {
        if (!checkPersonInTree(child)) {
            addBranchParentChild(getPersonFromTree(fatherName, yearOfBirthFather), child);
            addBranchParentChild(getPersonFromTree(motherName, yearOfBirthMother), child);
            familyTree.add(child);
        }
    }

    /**
     * Возвращает человека из списка древа
     *
     * @param person человек
     * @return Human
     */
    public Human getPersonFromTree(String person, int yearOfBirth) {
        Year temp = Year.of(yearOfBirth);
        for (Human person_ : familyTree
        ) {
            if (person_.getNAME().equalsIgnoreCase(person)
                    && person_.getYearOfBirth().equals(temp)) return person_;
        }
        return null;
    }

    private boolean checkPersonInTree(Human person) {
        return familyTree.contains(person);
    }

    /**
     * Для вывода родителей
     */
    public void showParents(String childName, int yearOfBirth) {
        Human child = getPersonFromTree(childName, yearOfBirth);
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
    public void showChildren(String parentName, int yearOfBirth) {
        Human parent = getPersonFromTree(parentName, yearOfBirth);
        if (parent != null) {
            List<Human> children = parent.getChildren();
            if (!children.isEmpty()) {
                System.out.print("-> родитель: " + parentName);

                System.out.print(" -> Дети: ");
                for (Human child : children) {
                    System.out.printf("%s%s ", "·", child.getNAME());
                }
                System.out.println();
            } else {
                System.out.println(parentName + " " + yearOfBirth + " не имеет детей.");
            }
        }
    }
}
