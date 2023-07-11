package family_tree;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Person {
    private String fullname;
    private GregorianCalendar birthDate;
    private GregorianCalendar endLifeDate;
    private Gender gender;
    private Person mother;
    private Person father;
    private List<Person> children;
    private String commit; // поле для доп. комментариев, например неизвестна точная дата рождения или если несколько мужей/жен и т.п.

    // CONSTRUCTORS
    public Person() {
        this.children = new ArrayList<>();
    }

    public Person(String fullname, Integer birthYYYY, Integer birthM, Integer birthD,
                  Integer endLifeYYYY, Integer endLifeM, Integer endLifeD, Gender gender,
                  Person mother, Person father, List<Person> children, String commit) {
        this.fullname = fullname;
        if (birthYYYY != null && birthM != null && birthD != null) {
            this.birthDate = new GregorianCalendar(birthYYYY, birthM-1, birthD);
        }
        if (endLifeYYYY != null && endLifeM != null && endLifeD != null) {
            this.endLifeDate = new GregorianCalendar(endLifeYYYY, endLifeM - 1, endLifeD);
        }
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
        // при создании экземпляра с указанием родителей конструктор будет проверять у Мамы и Папы,
        // ссылаются ли они на Ребенка в своих экземплярах, если нет, то сразу добавит
        if (mother != null && !mother.getChildren().contains(this)) {
            mother.getChildren().add(this);
        }
        if (father != null && !father.getChildren().contains(this)) {
            father.getChildren().add(this);
        }
        this.commit = commit;
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, Gender gender,
                  Person mother, Person father, List<Person> children) {
        this(fullname, birthYYYY, birthM, birthD, endLifeYYYY,
                endLifeM, endLifeD, gender, mother, father, children, null);
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, Gender gender, Person mother, Person father) {
        this(fullname, birthYYYY, birthM, birthD, endLifeYYYY,
                endLifeM, endLifeD, gender, mother, father, new ArrayList<Person>(), null);
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, Gender gender) {
        this(fullname, birthYYYY, birthM, birthD, endLifeYYYY, endLifeM, endLifeD, gender,
                null, null, new ArrayList<Person>(), null);
    }

    public Person(String fullname, Gender gender) {
        this(fullname, null, null, null, null, null, null, gender,
                null, null, new ArrayList<Person>(), null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy ");

        sb.append(fullname+":\n");

        String birthDateStr = birthDate == null ? "" : repeat(fullname.length()+1," ")+
                                                        "д.р. "+df.format(birthDate.getTime()).trim()+"\n";
        sb.append(birthDateStr);

        String endLifeDateStr = endLifeDate == null ? "" : repeat(fullname.length()+1," ")+
                                                            "д.с. "+df.format(endLifeDate.getTime()).trim()+"\n";
        sb.append(endLifeDateStr);

        String genderStr = gender == null ? "" : repeat(fullname.length()+1," ")+
                                                    "пол "+gender.toString()+"\n";
        sb.append(genderStr);

        String motherStr = mother == null ? "" : repeat(fullname.length()+1," ")+
                                                    "Мама "+mother.getName()+"\n";
        sb.append(motherStr);

        String fatherStr = father == null ? "" : repeat(fullname.length()+1," ")+
                                                    "Папа "+father.getName()+"\n";
        sb.append(fatherStr);

        String childrenStr = children.isEmpty() ? "" : repeat(fullname.length()+1," ")+
                                                        "Дети: "+this.getChildrenStr()+"\n";
        sb.append(childrenStr);

        String commitStr = commit == null ? "" : repeat(fullname.length()+1," ")+
                                                    "Доп.инфо - "+commit+"\n";
        sb.append(commitStr);

        return sb.toString();
    }

    // SETTERS
    public void setMother(Person mother) {
        if (mother != null) {
            this.mother = mother;
        }
    }

    public void setMotherForcedly(Person mother) {
            this.mother = mother;
    }

    public void setFather(Person father) {
        if (father != null) {
            this.father = father;
        }
    }

    public void setFatherForcedly(Person father) {
            this.father = father;
    }

    public void setChildren(Person child) {
        if (!children.contains(child)) {
            this.children.add(child);
        }
    }

    public void setBirthDate(int year, int month, int day) {
        GregorianCalendar birthDate = new GregorianCalendar(year, month - 1, day);
        this.birthDate = birthDate;
    }

    public void setEndLifeDate(int year, int month, int day) {
        GregorianCalendar endLifeDate = new GregorianCalendar(year, month - 1, day);
        this.endLifeDate = endLifeDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // GETTERS
    public String getName() {
        return fullname;
    }

    public String getBirthDate() {
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        return df.format(birthDate.getTime());
    }

    public String getEndLifeDate() {
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        return df.format(endLifeDate.getTime());
    }

    public Gender getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public String getChildrenStr() {
        StringBuilder sb = new StringBuilder();
        for (Person child : children) {
            sb.append(child.getName());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString().trim();
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getCommit() {
        return commit;
    }

    // метод используется в toString
    private String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

}
