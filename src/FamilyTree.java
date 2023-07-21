import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> humanList;

    public FamilyTree (List<Human> human){
        this.humanList = human;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    /**
     * Добавление в список нового человека
     * @param human
     */
    public void addHumanList(Human human){
        humanList.add(human);
    }

    /**
     * Получение полного списка людей в дереве
     * @return
     */
    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей: \n");
        stringBuilder.append("\n");
        for (Human human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        stringBuilder.append("=".repeat(50));
        return stringBuilder.toString();
    }

    /**
     * Поиск человека по имени
     * @param name
     * @return
     */
    public String findPerson(String name){
        System.out.println("Введите имя для поиска: ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей с именем " + name);
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        for (Human human: humanList) {
            if (human.getFirstName().equalsIgnoreCase(name.toLowerCase())){
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }



}

