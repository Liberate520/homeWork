import java.sql.Date;
//import java.util.List;

public class Human extends FamilyTree {
    private String firstName;   // Имя
//    private String middleName;  // Отчество
    private String lastName;    // Фамилия
    Gender sex;

    private String fatherName;
    private String motherName;
//    private Human father;   // объект в объекте?
//    private Human mother;   // объект в объекте?

    private Date birthday;
//    private String birthPlace; // место рождения
//    private List<Human> children;

    /**Родственник 2+ уровня */
    public Human(String firstName, String lastName, Gender sex, String fatherName, String motherName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.birthday = birthday;
    }

    /**Родоначальники 1-го уровня дерева */
    public Human(String firstName, String lastName, Gender sex, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Gender getSex() {
        return this.sex;
    }

    public String getSexInfo() {
        if (getSex() == Gender.valueOf("Male")) {
            return "муж.";
        } else {
            return "жен.";
        }
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFatherInfo() {
        if (fatherName != null) {
            return getFatherName().toString();
        } else {
            return "отсутствует";
        }
    }

    public String getMotherName() {
        return motherName;
    }


    public String getMotherInfo() {
        if (motherName != null) {
            return getMotherName().toString();
        } else {
            return "отсутствует";
        }
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
        @Override
    public String toString() {
        String dt = String.format("%s.%s.%s", this.birthday.getDay(), this.birthday.getMonth(),
                this.birthday.getYear());
        if (this.sex == Gender.Male) {
            return String.format("%s %s, муж., %s", this.firstName, this.lastName, dt);
        } else {
            return String.format("%s %s, жен., %s", this.firstName, this.lastName, dt);
        }
    }
*/

    /**
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 0; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствует");
        }
        return res.toString();
    }
     */

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(this.firstName);
        sb.append(", ");
        sb.append("Фамилия: ");
        sb.append(this.lastName);
        sb.append(", ");
        sb.append("день рождения: ");
        sb.append(this.birthday);
        sb.append(", ");
        sb.append("пол: ");
        sb.append(getSexInfo());
        sb.append(", ");
        sb.append("Имя отца: ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append("Имя матери: ");
        sb.append(getMotherInfo());
        sb.append(".");
        return sb.toString();
    }

    /** Сравнение двух людей по именам.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(gertName());
    }
     */

}
