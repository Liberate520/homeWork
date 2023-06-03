package FamilyTrees;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Класс, представляющий семейное древо.
 */
public class FamilyTree implements Serializable {
    private List<Human> familyTree;

    /**
     * Конструктор класса FamilyTree.
     */
    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    /**
     * /**
     * Добавляет связь ребенка и родителя.
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
        if (!isPersonInTree(person)) familyTree.add(person);
    }

    /**
     * Добавляет человека в семейное древо с одним предком.
     *
     * @param person      ребенок
     * @param parent      родитель
     * @param yearOfBirth год рождения родителя
     */
    public void addPersonInFamilyTree(Human person, String parent, int yearOfBirth) {
        if (!isPersonInTree(person)) {
            addBranchParentChild(getPersonFromTree(parent, yearOfBirth), person);
            familyTree.add(person);
        }
    }

    /**
     * Добавляет человека в семейное древо с двумя родителями.
     *
     * @param child             ребенок
     * @param fatherName        имя отца
     * @param yearOfBirthFather год рождения отца
     * @param motherName        имя матери
     * @param yearOfBirthMother год рождения матери
     */
    public void addPersonInFamilyTree(Human child,
                                      String fatherName, int yearOfBirthFather,
                                      String motherName, int yearOfBirthMother) {
        if (!isPersonInTree(child)) {
            addBranchParentChild(getPersonFromTree(fatherName, yearOfBirthFather), child);
            addBranchParentChild(getPersonFromTree(motherName, yearOfBirthMother), child);
            familyTree.add(child);
        }
    }

    /**
     * Возвращает человека из списка древа.
     *
     * @param personName  имя человека
     * @param yearOfBirth год рождения человека
     * @return объект Human, представляющий найденного человека, или null, если человек не найден
     */
    public Human getPersonFromTree(String personName, int yearOfBirth) {
        Year temp = Year.of(yearOfBirth);
        Optional<Human> result =
                familyTree.stream()
                        .filter(x -> x.getNAME().equalsIgnoreCase(personName) && x.getYearOfBirth().equals(temp))
                        .findFirst();
        return result.orElse(null);
    }

    private boolean isPersonInTree(Human person) {
        return familyTree.contains(person);
    }

    /**
     * Выводит родителей человека.
     *
     * @param childName   имя ребенка
     * @param yearOfBirth год рождения ребенка
     */
    public void showParents(String childName, int yearOfBirth) {
        Human child = getPersonFromTree(childName, yearOfBirth);
        if (child != null) {
            Human father = child.getFather();
            Human mother = child.getMother();
            System.out.println(
                    "-> Родитель: " + ((father != null) ? father.getNAME() : "неизвестно") + " + " +
                            "Родитель: " + ((mother != null) ? mother.getNAME() : "неизвестно") + " -> Ребенок: " + childName);
        } else {
            System.out.println(childName + " не найден в семейном древе.");
        }
    }

    /**
     * Выводит всех детей человека.
     *
     * @param parentName  имя родителя
     * @param yearOfBirth год рождения родителя
     */
    public void showChildren(String parentName, int yearOfBirth) {
        Human parent = getPersonFromTree(parentName, yearOfBirth);
        if (parent != null) {
            List<Human> children = parent.getChildren();
            if (!children.isEmpty()) {
                System.out.print("-> родитель: " + parent.getNAME());

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

    /**
     * Отображает семейное древо, печатая имена и годы рождения всех людей в древе.
     * Если древо пусто, выводит сообщение о пустом древе.
     */
    public void showFamilyTree() {
        if (familyTree.isEmpty()) {
            System.out.println("Семейное древо пусто.");
        } else {
            System.out.println("Семейное древо:");
            for (Human person : familyTree) {
                System.out.println(person.getNAME() + " (" + person.getYearOfBirth() + ")");
            }
        }
    }
}
