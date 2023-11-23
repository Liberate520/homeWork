package ru.medved_sa.tree_family.model.familyTree;

import ru.medved_sa.tree_family.model.familyTree.iterator.HumanIterator;
import ru.medved_sa.tree_family.model.human.comparator.HumanComparatorByAge;
import ru.medved_sa.tree_family.model.human.comparator.HumanComparatorByFirstName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends EntityCreation<T>> implements Serializable, Iterable<T> {
    private int humanId;
    private String nameFamilyTree;
    private List<T> humanList;

    /**
     * Конструктор создания сущности -> "Семейное дерево" с двумя параметрами.
     *
     * @param nameFamilyTree имя семейного дерева
     * @param humanList      готовый список сущностей (допустим из сохранения)
     */
    public FamilyTree(String nameFamilyTree, List<T> humanList) {
        this.nameFamilyTree = nameFamilyTree;
        this.humanList = humanList;
    }

    /**
     * Конструктор создания сущности -> "Семейное дерево" с одним параметром -> список сущностей
     *
     * @param humanList готовый список сущностей (допустим из сохранения)
     */
    public FamilyTree(List<T> humanList) {
        this(null, humanList);
    }

    /**
     * Конструктор создания сущности -> "Семейное дерево" с одним параметром -> имя
     *
     * @param nameFamilyTree имя семейного дерева
     */
    public FamilyTree(String nameFamilyTree) {
        this(nameFamilyTree, new ArrayList<>());
    }

    /**
     * Конструктор создания сущности -> "Семейное дерево" - без параметров.
     */
    public FamilyTree() {
        this(new ArrayList<>());
    }


    /**
     * Метод добавления сущности Human в семейное дерево. Условие if исключает возможность добавления двух
     * одинаковых сущностей. При удачном добавлении к сущности добавляется id.
     * Методы добавления детей к родителям и родителей к детям.
     *
     * @param human сущность добавляемого человека
     */
    public void addHuman(T human) {
        if (human == null) {
            return;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);
            addChildrenToParents(human);
            addParentsToChildren(human);
        } else {
            System.out.printf("В семейном дереве %s человек %s уже существует.\n",
                    getNameFamilyTree(), human.getFirstName());
        }
    }

    /**
     * Метод позволяющий найти человека хранящийся в заполненном семейном дереве по id
     *
     * @param id Номер id для поиска
     * @return найденный человек, иначе null
     */
    public T getById(long id) {
        if (!checkId(id)) {
            return null;
        }
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    /**
     * Метод boolean. Метод приватный, только для использования в методах внутри класса FamilyTree.
     * Проверка на существование человека в семейном дереве, с принимаемым в метод id.
     * Предварительная проверка: Если id выходит из диапазона humanId (humanId пока считается humanId++ при каждом
     * внесении в семейное дерево нового человека), то false
     * Далее в цикле: проверит всех людей в List<Human> humanList и если будет найдено соответствие - вернет true.
     *
     * @param id входящий id человека для его поиска
     * @return true/false
     */
    private boolean checkId(long id) {
        if (id >= humanId || id < 0) {
            return false;
        }
        for (T human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод перегружен, что позволяет делать запрос на создании семьи, как по id принимаемых в метод людей, так и
     * по их имени.
     * Метод "Свадьба". Если принятые в метод id двух человек, одновременно, существуют (true) в семейном дереве, то
     * в переменные human1 и human2 сохраняются найденные сущности, вся информация о человеке. Далее запускается
     * одноименный метод (перегруженный), который будет работать с найденными людьми.
     *
     * @param humanId1 id первой сущности
     * @param humanId2 id второй сущности
     */
    public void setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            setWedding(human1, human2);
        }
    }

    /**
     * Проверяется, что бы у этих сущностей поле spouse было одновременно, у обоих пустым, и только при выполнении
     * условия этой проверки происходит изменение поля spouse -> имя первой сущности заносится в поле spouse у второй,
     * и наоборот для второй сущности.
     *
     * @param human1 первая сущность
     * @param human2 вторая сущность
     */
    public void setWedding(T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    /**
     * Метод перегружен, что позволяет делать запрос на развод, как по id принимаемых в метод людей, так и
     * по их имени.
     * Метод "Развод". Если принятые в метод id двух человек, одновременно, существуют (true) в семейном дереве, то
     * в переменные human1 и human2 сохраняются найденные сущности, вся информация о человеке. Далее запускается
     * одноименный метод (перегруженный), который будет работать с найденными людьми.
     *
     * @param humanId1 id первой сущности
     * @param humanId2 id второй сущности
     */
    public void setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            setDivorce(human1, human2);
        }
    }

    /**
     * Проверяется, что бы у этих сущностей поле spouse было одновременно, НЕ пустыми, и только при выполнении
     * условия этой проверки происходит изменение поля spouse -> поле spouse у первой и у второй сущности очищаются,
     * перезаписываются (null). Развод состоялся...
     *
     * @param human1 первая сущность
     * @param human2 вторая сущность
     */
    public void setDivorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
        }
    }


    /**
     * Метод поиска братьев и сестер. Метод принимает id человека, у которого необходимо найти братьев и сестер.
     * Первая проверка: Если человек существует, то выполнимся следующий поиск..
     * Создается результирующий пустой список. Далее находим родителя проверяемого человека, у родителя находим ребенка
     * если найденный ребенок отличный от проверяемого или найденный, отличный от проверяемого ребенок еще не существует
     * в результирующем списке, то заносим найденного ребенка в список. Такая проверка позволяет исключить внесение в
     * результирующий список проверяемого ребенка и будет хранить в себе все данные, только найденного брата или
     * сестры. Проверка в двух циклах.
     *
     * @param id id ребенка у которого требуется найти брата или сестру.
     * @return Список всех данных о найденных братьях или сестрах.
     */
    public List<T> getSiblings(int id) {
        T human = getById(id);
        if (human == null) {
            return null;
        }
        List<T> result = new ArrayList<>();
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human) && !result.contains(child)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    /**
     * Метод проверяет принимаемую на вход сущность, и если внутри проверяемой сущности поле father, mother или сразу
     * оба поля заполнены (прикреплены к этим полям ссылки на родителей(ля)) то, входящая в метод сущность будет
     * добавлена к найденным родителям как ребенок.
     *
     * @param human Сущность, возможный потенциальный ребенок для добавления.
     */
    private void addChildrenToParents(T human) {
        for (T parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    /**
     * Метод проверяет принимаемую на вход сущность, и если внутри проверяемой сущности поле children заполнено,
     * прикреплена к этому полю ссылка на список детей то, входящая в метод сущность будет добавлена как родитель
     * ко всем найденным в списке детям.
     *
     * @param human Сущность, возможный потенциальный родитель для добавления.
     */
    private void addParentsToChildren(T human) {
        for (T child : human.getChildren()) {
            child.addParent(human);
        }
    }

    /**
     * Метод поиска информации о человеке, в семейном дереве, по входящему в метод имени.
     *
     * @param firstName имя человека
     * @return информация о человеке
     */
    public List<T> sortByFirstName(String firstName) {
        List<T> result = new ArrayList<>();
        for (T human : humanList) {
            if (human.getFirstName().equals(firstName)) {
                result.add(human);
            }
        }
        return result;
    }

    /**
     * Метод удаления человека из семейного дерева по его id.
     *
     * @param id человека
     * @return true/false
     */
    public boolean humanRemove(long id) {
        if (checkId(id)) {
            T human = getById(id);
            return humanList.remove(human);
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByFirstName() {
        humanList.sort(new HumanComparatorByFirstName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }


    /**
     * Переопределенный метод toString() для вывода в консоль всей информации о сущностях хранящихся в семейном дереве.
     *
     * @return getInfo()
     */
    @Override
    public String toString() {
        return getInfo();
    }

    /**
     * Метод формирования данных о всех сущностях хранящихся в семейном дереве.
     *
     * @return StringBuilder.toString()
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nСемейное дерево семьи: ");
        sb.append(getNameFamilyTree());
        sb.append(" (состоит из ");
        sb.append(humanList.size());
        sb.append(" объектов)");
        sb.append("\n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");

        }
        return sb.toString();
    }

    /**
     * Геттер
     *
     * @return Вернет имя семейного дерева
     */
    public String getNameFamilyTree() {
        return nameFamilyTree;
    }

}
