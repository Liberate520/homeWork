package model.familyTrees;

import model.familyTrees.comparators.ByDateBirth;
import model.familyTrees.comparators.NameAlphabetical;
import model.familyTrees.comparators.NameLength;
import model.familyTrees.iterators.PersonIterator;
import model.members.Gender;
import model.members.Member;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Класс, представляющий семейное древо.
 */
public class FamilyTree<T extends Member> implements Serializable, Iterable<T> {
    private List<T> familyTree;
    private String nameFamilyTree;

    /**
     * Конструктор класса FamilyTree.
     */
    public FamilyTree(String nameFamilyTree) {
        this.nameFamilyTree = nameFamilyTree;
        this.familyTree = new ArrayList<>();
    }



    public String getNameFamilyTree() {
        return nameFamilyTree;
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    /**
     * /**
     * Добавляет связь ребенка и родителя.
     *
     * @param parent родитель
     * @param child  ребенок
     */
    public void addBranchParentChild(T parent, T child) {
        if (parent != null) {
            if (parent.getGender().equals(Gender.MAN)) {
                child.setFather(parent);
                addChildBranch(parent, child);
            }
            if (parent.getGender().equals(Gender.WOMAN)) {
                child.setMother(parent);
                addChildBranch(parent, child);
            }
        }
    }

    /**
     * Проверяет есть ли у родителя нужный ребенок, если нет, добавляет его в список.
     *
     * @param parent Родитель
     * @param child  ребенок
     */
    private void addChildBranch(T parent, T child) {

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
    public void addPersonInFamilyTree(T person) {
        if (!isPersonInTree(person)) familyTree.add(person);
    }

    /**
     * Добавляет человека в семейное древо с одним предком.
     *
     * @param person      ребенок
     * @param parent      родитель
     * @param yearOfBirth год рождения родителя
     */
    public void addPersonInFamilyTree(T person, String parent, int yearOfBirth) {
        if (!isPersonInTree(person)) {
            addBranchParentChild(getHumanFromTree(parent, yearOfBirth), person);
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
    public void addPersonInFamilyTree(T child,
                                      String fatherName, int yearOfBirthFather,
                                      String motherName, int yearOfBirthMother) {
        if (!isPersonInTree(child)) {
            addBranchParentChild(getHumanFromTree(fatherName, yearOfBirthFather), child);
            addBranchParentChild(getHumanFromTree(motherName, yearOfBirthMother), child);
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
    public T getHumanFromTree(String personName, int yearOfBirth) {
        Year temp = Year.of(yearOfBirth);
        Optional<T> result =
                familyTree.stream()
                        .filter(x -> x.getName().equalsIgnoreCase(personName) && x.getYearOfBirth().equals(temp))
                        .findFirst();
        return result.orElse(null);
    }


    /**
     * Проверяет есть ли человек в древе
     *
     * @param person
     * @return
     */
    private boolean isPersonInTree(T person) {
        return familyTree.contains(person);
    }


    /**
     * Выводит родителей человека.
     *
     * @param parentName  имя родителя
     * @param yearOfBirth год рождения ребенка
     */
    public List<Member> getParents(String parentName, int yearOfBirth) {
        T child = getHumanFromTree(parentName, yearOfBirth);
        List<Member> temp = new ArrayList<>();
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
    public List<Member> getChildren(String parentName, int yearOfBirth) {
        return Optional.ofNullable(getHumanFromTree(parentName, yearOfBirth))
                .map(T::getChildren).orElse(null);
    }

    /**
     * Отображает семейное древо, печатая имена и годы рождения всех людей в древе.
     * Если древо пусто, выводит сообщение о пустом древе.
     */

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(familyTree);
    }

    /**
     * Сортирует древо по дате рождения
     */
    public void sortTreeByDateBirth() {
        familyTree.sort(new ByDateBirth<>());
    }

    /**
     * Сортирует древо в алфавитном порядке
     */
    public void sortTreeByAlphabeticalOrder() {

        familyTree.sort(new NameAlphabetical<>());
    }

    /**
     * Сортирует древо по длине имени
     */
    public void sortTreeByNameLength() {
        familyTree.sort(new NameLength<>());
    }

    public int familyTreeSize() {
        return familyTree.size();
    }
}
