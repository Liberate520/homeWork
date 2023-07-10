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
    private String gender;
    private Person mother;
    private Person father;
    private List<Person> children;
    private String commit;

    // constructors
    public Person() {
        this.children = new ArrayList<>();
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, String gender,
                  Person mother, Person father, List<Person> children, String commit) {
        this.fullname = fullname;
        this.birthDate = new GregorianCalendar(birthYYYY, birthM-1, birthD);
        this.endLifeDate = new GregorianCalendar(endLifeYYYY, endLifeM-1, endLifeD);
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.commit = commit;
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, String gender,
                  Person mother, Person father, List<Person> children) {
        this(fullname, birthYYYY, birthM, birthD, endLifeYYYY,
                endLifeM, endLifeD, gender, mother, father, children, null);
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, String gender, Person mother, Person father) {
        this(fullname, birthYYYY, birthM, birthD, endLifeYYYY,
                endLifeM, endLifeD, gender, mother, father, new ArrayList<Person>(), null);
    }

    public Person(String fullname, int birthYYYY, int birthM, int birthD,
                  int endLifeYYYY, int endLifeM, int endLifeD, String gender) {
        this(fullname, birthYYYY, birthM, birthD, endLifeYYYY, endLifeM, endLifeD, gender,
                null, null, new ArrayList<Person>(), null);
    }

    public Person(String fullname, String gender) {
        this.fullname = fullname;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy ");

        sb.append(fullname);

        String birthDateStr = birthDate == null ? "" : ", ДР "+df.format(birthDate.getTime()).trim();
        sb.append(birthDateStr);

        String endLifeDateStr = endLifeDate == null ? "" : ", ДС "+df.format(endLifeDate.getTime()).trim();
        sb.append(endLifeDateStr);

        String genderStr = gender == null ? "" : ", Пол "+gender.toLowerCase();
        sb.append(genderStr);

        String motherStr = mother == null ? "" : ", Мама "+mother.getName();
        sb.append(motherStr);

        String fatherStr = father == null ? "" : ", Папа "+father.getName();
        sb.append(fatherStr);

        String childrenStr = children.isEmpty() ? "" : ", Дети "+this.getChildren();
        sb.append(childrenStr);

        String commitStr = commit == null ? "" : ", Доп.инфо-"+commit;
        sb.append(commitStr);

        return sb.toString();
    }

    // setters
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // getters
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

    public String getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public String getChildren() {
        StringBuilder sb = new StringBuilder();
        for (Person child : children) {
            sb.append(child.getName());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String getCommit() {
        return commit;
    }

}
