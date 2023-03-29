import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Объект персона содержит информация о себе: имя, пол, дату рождения и дату
 * смерти(если таковая имеется)
 * Содержит имена и индентифиаторы на родителей
 * Содержит индитификаторы детей, если такие имееются.
 */

public class Person {
    private Map<String, String> person_info;
    private String person_name, person_sex;
    public Date person_birthday, person_death;
    private int person_id;
    private Person mother, father;
    private ArrayList<Person> person_childs = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    // Конструктор вызываемый из класса дерево с уже загруженной базой
    // для создания объекта человека с его ранее записанными данными
    Person(int ids, Map<String, String> info) {
        this.person_id = ids;
        this.person_info = info;

        if (this.person_info.size() > 0) {

            this.person_sex = this.person_info.get("person_sex");
            this.person_name = this.person_info.get("person_name");

            this.person_birthday = strToDate(this.person_info.get("person_birthday"));
            this.person_death = strToDate(this.person_info.get("person_death"));
        }

    }

    Person(String name) {
        this.person_name = name;
        this.person_id = (int) System.currentTimeMillis();
    }

    Person() {
        this("");
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getPerson_name() {
        return this.person_name;
    }

    public String getPerson_sex() {
        return person_sex;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public Date getPerson_birthday() {
        return person_birthday;
    }

    public Date getPerson_death() {
        return person_death;
    }

    public String getPersonBirthdayString() {
        return formatter.format(person_birthday);
    }

    public String getPersonDeathString() {
        return formatter.format(person_death);
    }

    public ArrayList<Person> getPerson_childs() {
        return person_childs;
    }

    public void setPerson_sex(String person_sex) {
        this.person_sex = person_sex;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setPerson_childs(Person childs) {
        this.person_childs.add(childs);
    }



    public Map<String, String> getPersonInfo() {
        return person_info;
    }

    @Override
    public String toString() {
        String res = String.format("\nName:\t\t%s\t[%s, id: %d]\n", this.getPerson_name(), this.person_sex, this.person_id);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        
        if (this.person_birthday!=null)
            res += String.format("Date of Birth:\t%s\n", formatter.format(this.person_birthday));
    
        if (this.person_death!=null)
            res += String.format("Date of death:\t%s\n", formatter.format(this.person_death));

        if (this.mother != null)
            res += String.format("mother:\t\t%s\t[id: %d]\n", this.mother.getPerson_name(), this.mother.person_id);
        if (this.father != null)
            res += String.format("father:\t\t%s\t[id: %d]\n", this.father.getPerson_name(), this.father.person_id);

        for (Person child : person_childs) {
            res += String.format("child:\t\t%s\t[%s, id: %d]\n", child.getPerson_name(), child.getPerson_sex(), child.person_id);
        }
        return res;
    }

    private Date strToDate(String date) {
        Date docDate;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        try {
            docDate = format.parse(date);
        } catch (Exception e) {
            docDate = null;
        }
        return docDate;
    }

}
