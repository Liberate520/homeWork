package familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;
import familyTree.tree.FamilyTree;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServiceForTree implements Serializable {

    private int id;
    private final Map<String, FamilyTree> TREE_GROUP = new LinkedHashMap<>();

    /**
     * Конструктор
     * @param treeName имя древа
     * @param currentTree текущее древо
     */
    public ServiceForTree(String treeName, FamilyTree currentTree) {
        TREE_GROUP.putIfAbsent(treeName, currentTree);
    }

    /**
     * Конструктор
     * @param treeName имя древа
     */
    public ServiceForTree(String treeName){
        this(treeName, new FamilyTree());
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
                             String fullName, Gender gender,
                             String dateOfBirth, String dateOfDeath,
                             String mother, String father,
                             String spouse, String children) {
        for (Map.Entry<String, FamilyTree> tree : TREE_GROUP.entrySet()){
            if (tree.getKey().equals(treeName)) {
                tree.getValue().addNewHuman(new Human(id++, fullName, gender, dateOfBirth,
                        dateOfDeath, mother, father, spouse, children));
            }
            else {
                this.addTree(treeName);
                this.getTree(treeName).addNewHuman(new Human(id++, fullName, gender, dateOfBirth,
                        dateOfDeath, mother, father, spouse, children));
            }
        }
    }

    /**
     * Добавление нового древа
     * @param treeName имя древа
     */
    public void addTree(String treeName){
        this.TREE_GROUP.putIfAbsent(treeName, new FamilyTree());
    }


    /**
     * Получение всей информации
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
     * Получение конкретного древа из общего списка по его имени
     * @param treeName имя древа
     * @return объект FamilyTree
     */
    public FamilyTree getTree(String treeName){
        return TREE_GROUP.getOrDefault(treeName, new FamilyTree());
    }
}
