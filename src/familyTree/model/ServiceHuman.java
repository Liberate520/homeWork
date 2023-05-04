package familyTree.model;

import familyTree.model.human.Human;
import familyTree.model.tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServiceHuman implements Serializable {

    private int id;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final Map<String, FamilyTree> TREE_GROUP = new LinkedHashMap<>();

    /**
     * Конструктор
     * @param treeName имя древа
     * @param currentTree текущее древо
     */
    public ServiceHuman(String treeName, FamilyTree currentTree) {
        TREE_GROUP.putIfAbsent(treeName, currentTree);
    }

    /**
     * Конструктор
     * @param treeName имя древа
     */
    public ServiceHuman(String treeName){
        this(treeName, new FamilyTree());
    }

    /**
     * Добавление нового древа
     * @param treeName имя древа
     */
    private void addTree(String treeName){
        this.TREE_GROUP.putIfAbsent(treeName, new FamilyTree());
    }

    /**
     * Получение конкретного древа из общего списка по его имени
     * @param treeName имя древа
     * @return объект FamilyTree
     */
    private FamilyTree getConcreteTree(String treeName){
        return TREE_GROUP.getOrDefault(treeName, new FamilyTree());
    }

    /**
     * Получение конкретного человека из конкретного древа по их именам
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return объект Human
     */
    private Human getConcreteHuman(String treeName, String fullName){
        return this.getConcreteTree(treeName).getHumanByFullName(fullName);
    }

    /**
     * Добавление нового человека в уже имеющееся, в общем списке
     * или новое древо.
     * @param treeName имя древа (ключ)
     * @param fullName имя человека
     * @param gender пол
     * @param dateOfBirth дата рождения
     * @param dateOfDeath дата смерти
     * @param mother имя матери
     * @param father имя отца
     * @param spouse имя(имена) супруга(ов)
     * @param children имена детей
     */
    public void addToTree(String treeName,
                             String fullName, String gender,
                             String dateOfBirth, String dateOfDeath,
                             String mother, String father,
                             String spouse, String children) {
        this.addTree(treeName);
        this.getConcreteTree(treeName).addNewHuman(new Human(id++, fullName, gender, dateOfBirth,
                        dateOfDeath, mother, father, spouse, children));
    }

    /**
     * Получение информации по всем древам
     * @return форматированная строка
     */
    public String getAllInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, FamilyTree> tree : TREE_GROUP.entrySet()) {
            sb.append(tree.getKey()).append("\n");
            sb.append(tree.getValue().showAll()).append("**********\n");
        }
        return sb.toString();
    }

    /**
     * Получение всей информации по конкретному древу
     * @param treeName имя древа
     * @return форматированная строка
     */
    public String getInfoConcreteTree(String treeName){
        return this.getConcreteTree(treeName).showAll();
    }

    /**
     * Получение информации по конкретному человеку из конкретного древа
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoHumanFromTree(String treeName, String fullName){
        return this.getConcreteTree(treeName).searchInfoHuman(fullName);
    }

    /**
     * Получение информации о поле человека
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoGender(String treeName, String fullName){
        return getConcreteHuman(treeName, fullName).getGender();
    }

    /**
     * Получение имён родителей
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoParents(String treeName, String fullName){
        return getConcreteHuman(treeName, fullName).getNameParents();
    }

    /**
     * Получение даты рождения человека
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoDateOfBirth(String treeName, String fullName){
        LocalDate dateOfBirth = getConcreteHuman(treeName, fullName).getDateOfBirth();
        return dateOfBirth.format(formatter);
    }

    /**
     * Получение даты смерти человека
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoDateOfDeath(String treeName, String fullName){
        LocalDate dateOfDeath = getConcreteHuman(treeName, fullName).getDateOfDeath();
        return dateOfDeath != null ? dateOfDeath.format(formatter) : "Человек жив";
    }

    /**
     * Получение возраста человека
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return число
     */
    public String getInfoAge(String treeName, String fullName){
        int age = getConcreteHuman(treeName, fullName).getAge();
        return String.format("возраст (в годах): %d", age);
    }

    /**
     * Получение информации о супругах
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoSpouse(String treeName, String fullName) {
        return getConcreteHuman(treeName, fullName).getSpouse();
    }

    /**
     * Получение информации о детях
     * @param treeName имя древа
     * @param fullName полное имя человека
     * @return форматированная строка
     */
    public String getInfoChildren(String treeName, String fullName) {
        return getConcreteHuman(treeName, fullName).getChildren();
    }
}
