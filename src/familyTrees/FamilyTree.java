package familyTrees;

import familyTrees.comparators.ByDateBirth;
import familyTrees.comparators.NameAlphabetical;
import familyTrees.comparators.NameLength;
import human.Human;
import human.iterators.HumanIterator;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Класс, представляющий семейное древо.
 */
public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree;

    /**
     * Конструктор класса FamilyTree.
     */
    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public List<Human> getFamilyTree() {
        return familyTree;
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

    /**
     * Проверяет есть ли человек в древе
     *
     * @param person
     * @return
     */
    private boolean isPersonInTree(Human person) {
        return familyTree.contains(person);
    }

    /**
     * Выводит родителей человека.
     *
     * @param parentName  имя родителя
     * @param yearOfBirth год рождения ребенка
     */
    public List<Human> getParents(String parentName, int yearOfBirth) {
        Human child = getPersonFromTree(parentName, yearOfBirth);
        List<Human> temp = new ArrayList<>();
        if (child != null) {
            temp.add(child.getFather());
            temp.add(child.getMother());
            return temp;
        } else return temp;
    }

    /**
     * Выводит всех детей человека.
     *
     * @param parentName  имя родителя
     * @param yearOfBirth год рождения родителя
     */
    public List<Human> getChildren(String parentName, int yearOfBirth) {
        return Optional.ofNullable(getPersonFromTree(parentName, yearOfBirth))
                .map(Human::getChildren).orElse(null);
    }

    /**
     * Отображает семейное древо, печатая имена и годы рождения всех людей в древе.
     * Если древо пусто, выводит сообщение о пустом древе.
     */

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

    /**
     * Сортирует древо по дате рождения
     */
    public void sortTreeByDateBirth() {
        familyTree.sort(new ByDateBirth());
    }

    /**
     * Сортирует древо в алфавитном порядке
     */
    public void sortTreeByAlphabeticalOrder() {

        familyTree.sort(new NameAlphabetical());
    }

    /**
     * Сортирует древо по длине имени
     */
    public void sortTreeByNameLength() {
        familyTree.sort(new NameLength());
    }

}
