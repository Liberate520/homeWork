package tree;
import human.Human;
import java.util.*;

public class FamilyTree {
    private final List< Human > FamilyList;
    private int id = 1;
    public FamilyTree() {
        FamilyList = new ArrayList<>();
    }

    /**
     * Добавление человека в FamilyList с проверкой уникальности
     * @param human
     */
    public void addHuman(Human human) {
        human.setId(id++);
        if (!FamilyList.contains(human)) FamilyList.add(human);
    }

    /**
     * Вывод в строках всех членов семьи с датами, родителями, детьми, возрастом, полом и ID, полученная при переборе элементов в FamilyList
     * @return Строка
     */
    public String AllTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Вывод всех членов семьи\n").append("-".repeat(128)).append("\n");
        for (Human member: FamilyList) {
            sb.append(member.getId());
            sb.append(member.getFullName());
            sb.append("; ");
            sb.append("Дата рождения: ").append(member.getDayOfBirth()).append("; ");

            if(member.getDayOfDeath()!=null) {
                sb.append("Дата смерти: ");
                sb.append(member.getAge());
                sb.append("; ");
            }
            else {
                sb.append("Возраст: ");
                sb.append(member.getAge());
                sb.append(" лет; ");
            }
            sb.append(member.getParents().replace("{", "").replace("}", ""));
            sb.append("; ");
            sb.append(member.getSpouse());
            sb.append("; ");
            sb.append(member.getChildren().replace("[", " ").replace("]", " ").strip()).append("\n");
            sb.append("-".repeat(128));
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Поиск и вывод в строку Данных о человеке по поисковому слову "name", которое может содержаться в имени или фамилии
     * @param name
     * @return Строка данных "ID, Фамилия, Имя, Родители, Дети"
     */
    public String SearchByNameSurname (String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Результат поиска: \n");
        for (Human member: FamilyList) {
            if(member.getName().contains(name)|| member.getLastname().contains(name)){
                sb.append(member.getId());
                sb.append(member.getFullName());
                sb.append("; ");
                sb.append(member.getParents().replace("{", "").replace("}", ""));
                sb.append("; ");
                sb.append(member.getChildren().replace("[", "").replace("]", ""));
                sb.append("; ");
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
