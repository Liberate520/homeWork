package genTree;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import interfaces.Loadable;
import interfaces.Saveable;

public class Human implements Saveable, Loadable {
    private static String fileExt;

    private int id;
    private String firstName;
    private String midName;
    private String lastName;
    private Gender gender;
    private String strGender;
    private GregorianCalendar birthDate;
    private GregorianCalendar deathDate;
    private String strBirthDate = "UnknownBirthDate";
    private String strDeathDate = "UnknownDeathDate";
    private Human mother;
    private Human father;
    private ArrayList<Human> childs;

    static {
        fileExt = ".human";
    }

    // конструктор
    public Human(int id,
                 String firstName,
                 String midName,
                 String lastName,
                 Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.gender = gender;
        if (this.gender == Gender.man) {
            strGender = "Мужчина";
        }
        else {
            strGender = "Женщина";
        }
        childs = new ArrayList<Human>();
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Human> getChilds() {
        return childs;
    }

    public void setBirthDate(int day, int month, int year) {
        GregorianCalendar birthDate = new GregorianCalendar(year, month - 1, day);
        if (this.deathDate != null && birthDate.after(this.deathDate)) {
            throw new ArithmeticException("birthDate can not be after deathDate");
        }
        else {
            this.birthDate = birthDate;
            this.strBirthDate = dateToString(birthDate);
        }
    }

    public void setDeathDate(int day, int month, int year) {
        GregorianCalendar deathDate = new GregorianCalendar(year, month - 1, day);
        if (this.birthDate != null && deathDate.before(this.birthDate)) {
            throw new ArithmeticException("deathDate can not be before birthDate");
        }
        else {
            this.deathDate = deathDate;
            this.strDeathDate = dateToString(deathDate);
        }
    }

    public void changeFullName(String firstName,
                               String midName,
                               String lastName) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
    }

    public Human getMother() {
        return this.mother;
    }

    public Human getFather() {
        return this.father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public void setFather(Human father) {
        this.father = father;
        father.addChild(this);
    }

    public void addChild(Human child) {
        if (!(this.childs.contains(child))) {
            this.childs.add(child);
            if (this.gender == Gender.man) {
                child.setFather(this);
            }
            else {
                child.setMother(this);
            }
        }
    }

    private String dateToString(GregorianCalendar date) {
        // day = 5
        // month = 2
        // year = 1
        int day = date.get(5);
        int month = date.get(2) + 1;
        int year = date.get(1);
        return String.format("%s.%s.%s", day, month, year);
    }

    private String datesInfo() {
        return strBirthDate + " - " + strDeathDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human other = (Human)obj;
        return this.id == other.id &&
               this.firstName.equals(other.firstName) &&
               this.midName.equals(other.midName) &&
               this.lastName.equals(other.lastName) &&
               this.gender == other.gender;
    }

    @Override
    public String toString() {
        return "id=" + id + " " + getFullName() + " " + datesInfo();
    }

    public String getFullName() {
        return String.format("%s %s %s", firstName, midName, lastName);
    }

    public void showFullInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-----------------------------------------------------\n");
        sb.append(toString());
        sb.append(" ");
        sb.append(strGender);

        sb.append("\nОтец: ");
        if (father == null) {sb.append("unknown");}
        else {sb.append(father.getFullName());}

        sb.append("\nМать: ");
        if (mother == null) {sb.append("unknown");}
        else {sb.append(mother.getFullName());}

        sb.append("\nДети:\n");
        sb.append(getChilds());
        sb.append("\n-----------------------------------------------------\n");
        System.out.println(sb.toString());
    }

    @Override
    public String getFileExt() {
        return fileExt;
    }
}