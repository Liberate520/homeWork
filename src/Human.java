import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String lastname;
    private String firstname;
    private String patronymic;
    private GenderType sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String lastname, String firstname, String patronymic, GenderType sex) {
        this(lastname, firstname, patronymic, sex, null, null);
    }

    public Human(String lastname, String firstname, String patronymic, GenderType sex, Human father, Human mother) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n ФИО: ");
        sb.append(lastname);
        sb.append(" ");
        sb.append(firstname);
        sb.append(" ");
        sb.append(patronymic);
        sb.append(getMotherInfo());
        sb.append(getFatherInfo());
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getMotherInfo() {
        String res = "\nМать: ";
        if (mother != null) {
            res += mother.getLastname();
            res += ' ';
            res += mother.getFirstname();
            res += ' ';
            res += mother.getPatronymic();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "\nОтец: ";
        if (father != null) {
            res += father.getLastname();
            res += ' ';
            res += father.getFirstname();
            res += ' ';
            res += father.getPatronymic();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("\nДети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getFirstname());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getFirstname());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human human)) {
            return false;
        }
        return human.getFirstname().equals(getFirstname()) && human.getLastname().equals(getLastname());
    }

    @Override
    public int compareTo(Human o) {
        return lastname.compareTo(o.getLastname());
    }
}