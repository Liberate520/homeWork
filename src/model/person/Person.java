package model.person;

import java.io.Serializable;
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

public class Person implements Human, Serializable {
    private Map<String, String> person_info;
    private String person_name, person_sex;
    private Date person_birthday, person_death;
    private int person_id;
    private Person mother, father;
    private ArrayList<Person> person_childs = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    // Конструктор вызываемый из класса дерево с уже загруженной базой
    // для создания объекта человека с его ранее записанными данными
    public Person(Map<String, String> info) {
        this.person_info = info;
        this.person_id = Integer.parseInt(info.get("person_id"));
        this.person_name = info.get("person_name");
        this.person_sex = info.get("person_sex");
        this.person_birthday = strToDate(info.get("person_birthday"));
        this.person_death = strToDate(info.get("person_death"));
    }

    public Person(int id, String name) {
        this.person_name = name;
        this.person_id = id;
    }
    
    public String getFullInfoInText() {
        StringBuilder res = new StringBuilder();
        res.append("person_id:" + this.person_id + ",");
        res.append("person_name:" + this.person_name + ",");
        res.append("person_sex:" + this.person_sex + ",");
        res.append("person_birthday:" + this.getPersonBirthdayString() + ",");
        res.append("person_death:" + this.getPersonDeathString() + ",");
        res.append("mother_id:" + this.getMother_id() + ",");
        res.append("father_id:" + this.getFather_id() + ",");
        int i = 1;
        for (Person child : person_childs) {
            res.append("child" + i + ":" + child.getPerson_id() + ",");
            i++;
        }
        res.replace(res.length() - 1, res.length(), "");
        return res.toString();
    }

    public String toStringFull() {
        String res = String.format("\nName:\t\t%s\t[%s, id: %d]\n", this.getPerson_name(), this.person_sex,
                this.person_id);

        res += String.format("Date of Birth:\t%s\n", this.getPersonBirthdayString());
        res += String.format("Date of death:\t%s\n", this.getPersonDeathString());

        if (this.mother != null)
            res += String.format("mother:\t\t%s\t[id: %d]\n", this.mother.getPerson_name(), this.mother.person_id);
        if (this.father != null)
            res += String.format("father:\t\t%s\t[id: %d]\n", this.father.getPerson_name(), this.father.person_id);

        for (Person child : person_childs) {
            res += String.format("child:\t\t%s\t[%s, id: %d]\n", child.getPerson_name(), child.getPerson_sex(),
                    child.person_id);
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("id: " + this.getPerson_id() + ":\t");
        res.append(this.getPerson_name() + "\t\t");
        res.append("Birhday:" + this.getPersonBirthdayString() + "\n");
        return res.toString();
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

    @Override
    public int getPerson_id() {
        return this.person_id;
    }

    @Override
    public String getPerson_name() {
        return this.person_name;
    }

    public String getPerson_sex() {
        return person_sex;
    }

    public Person getFather() {
        return this.father;
    }

    public String getFather_id() {
        if (this.father != null)
            return Integer.toString(this.father.getPerson_id());
        return "";
    }

    public Person getMother() {
        return this.mother;
    }

    public String getMother_id() {
        if (this.mother != null)
            return Integer.toString(this.mother.getPerson_id());
        return "";
    }

    public Map<String, String> getPerson_info() {
        return person_info;
    }

    public Date getPerson_birthday() {
        return person_birthday;
    }

    public Date getPerson_death() {
        return person_death;
    }

    public String getPersonBirthdayString() {
        if (person_birthday != null) {
            return formatter.format(person_birthday);
        }
        return "";
    }

    public String getPersonDeathString() {
        if (person_death != null) {
            return formatter.format(person_death);
        }
        return "";
    }

    public ArrayList<Person> getPerson_childs() {
        return person_childs;
    }
    
    @Override
    public void setPerson_id(int id) {
        this.person_id = id;
    }

    @Override
    public void setPerson_name(String name) {
        this.person_name = name;
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

    public void setPerson_birthday(Date person_birthday) {
        this.person_birthday = person_birthday;
    }

    public void setPerson_death(Date person_death) {
        this.person_death = person_death;
    }

}
