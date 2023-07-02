package human;

// есть ещё LocalDate
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Human {
    private int id;
    private String firstName;
    private String midName;
    private String lastName;
    private Gender gender;
    private String strGender;
    private GregorianCalendar birthDate;
    private GregorianCalendar deathDate;
    private Human mother;
    private Human father;
    private ArrayList<Human> childs;
    private ArrayList<Integer> childsIds;

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
        childsIds = new ArrayList<Integer>();
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

    public ArrayList<Integer> getChildsIds() {
        return childsIds;
    }

    // есть ещё LocalDate
    public void setBirthDate(int day, int month, int year) {
        GregorianCalendar birthDate = new GregorianCalendar(year, month - 1, day);
        if (this.deathDate != null) {
            if (birthDate.before(this.deathDate)) {
                this.birthDate = birthDate;
            }
            else {
                throw new ArithmeticException("birthDate can not be after deathDate");
            }
        }
        else {
            this.birthDate = birthDate;
        }
    }

    public void setDeathDate(int day, int month, int year) {
        GregorianCalendar deathDate = new GregorianCalendar(year, month - 1, day);
        if (this.birthDate != null) {
            if (deathDate.after(this.birthDate)) {
                this.deathDate = deathDate;
            }
            else {
                throw new ArithmeticException("deathDate can not be before birthDate");
            }
        }
        else {
            this.deathDate = deathDate;
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
        if (this.childs.contains(child)) {
            // pass
        }
        else {
            this.childs.add(child);
            if (this.gender == Gender.man) {
                child.setFather(this);
            }
            else {
                child.setMother(this);
            }
        }
    }

    // требует доработки
    private String formattedDate(GregorianCalendar date) {
        // day = 5
        // month = 2
        // year = 1
        int day = date.get(5);
        int month = date.get(2) + 1;
        int year = date.get(1);
        return String.format("%s.%s.%s", day, month, year);
    }

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

    public String toString() {
        if (birthDate == null && deathDate == null) {
            return "id=" + id + " " + getFullName() + " UnknownBirthDate - UnknownDeathDate";
        }
        else if (birthDate == null) {
            return "id=" + id + " " + getFullName() + " UnknownBirthDate - " + formattedDate(deathDate);
        }
        else if (deathDate == null) {
            return "id=" + id + " " + getFullName() + " " + formattedDate(birthDate) + " - UnknownDeathDate";
        }
        else {
            return "id=" + id + " " + getFullName() + " " + formattedDate(birthDate) + " - " + formattedDate(deathDate);
        }
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
}