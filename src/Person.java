import java.util.ArrayList;
import java.util.Map;

/**
 * Объект персона содержит информация о себе: имя, пол, дату рождения и дату смерти(если таковая имеется)
 * Содержит имена и индентифиаторы на родителей
 * Содержит индитификаторы детей, если такие имееются. 
 */

public class Person {
    private Map<String, String> person_info;
    public String person_name, mother_name, father_name, person_sex;
    public String person_birthday, person_death; // Дата рождения и дата смерти
    private int person_id, mother_id, father_id;
    private ArrayList<Integer> person_childs_id;

    // Конструктор вызываемый из класса дерево с уже загруженной базой
    // для создания объекта человека с его ранее записанными данными
    Person(Integer ids, Map<Integer, Map<String, String>> bd_tree) {
        this.person_id = ids;
        this.person_info = bd_tree.get(this.person_id);

        if (this.person_info.size() > 0) {
            this.mother_id = Integer.parseInt(this.person_info.get("mother_id"));
            this.father_id = Integer.parseInt(this.person_info.get("father_id"));
            this.person_sex = this.person_info.get("person_sex");
            this.person_name = this.person_info.get("person_name");
            this.person_birthday = this.person_info.get("person_birthday");
            this.person_death= this.person_info.get("person_death");
        }

        for (Map.Entry<String, String> item : this.person_info.entrySet()) {
            if (item.getKey().contains("child")) {
                this.person_childs_id.add(Integer.parseInt(item.getValue()));
            }
        }
    }

    Person(String name) {
        this.person_name = name;
        this.person_id = (int) System.currentTimeMillis() / 1000;
    }

    Person() {
        this("");
    }

    public int getPerson_id() {
        return person_id;
    }

    public Map<String, String> getPersonInfo() {
        return person_info;
    }

}
