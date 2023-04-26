package familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;
import familyTree.tree.FamilyTree;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServiceForTree implements Serializable {

    private int id;
    private String treeName;
    private FamilyTree currentTree;
    private Map<String, FamilyTree> treeGroup = new LinkedHashMap<>();

    public ServiceForTree(String treeName, FamilyTree currentTree) {
        this.currentTree = currentTree;
        this.treeName = treeName;
        treeGroup.putIfAbsent(treeName, currentTree);
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
        for (Map.Entry<String, FamilyTree> tree : treeGroup.entrySet()){
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
        this.treeGroup.putIfAbsent(treeName, new FamilyTree());
    }


    /**
     * Получение всей информации
     * @return форматированная строка
     */
    public String getAllInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, FamilyTree> tree : treeGroup.entrySet()) {
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
        return treeGroup.getOrDefault(treeName, new FamilyTree());
    }
}
