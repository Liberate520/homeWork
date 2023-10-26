import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Date birthday;
    private Gender gender;
    private String first_parent;
    private String second_parent;
    private int hash;
    private List<Human> children = new ArrayList<>();

    public Human(int id, String name, Date birthday, Gender gender, String first_parent, String second_parent, int hash) {
        this.id = id;
        this.first_parent = first_parent;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.second_parent = second_parent;
        this.hash = hash;
        children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public void setFirst_parent(String first_parent) {
        this.first_parent = first_parent;
    }

    public Human() {

    }

    public String getFirstParent() {
        return first_parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSecondParent() {
        return second_parent;
    }

    public void setSecondParent(String second_parent) {
        this.second_parent = second_parent;
    }

    public StringBuilder getChildren() {
        StringBuilder res = new StringBuilder();
//        res.append(" ");
        if (!children.isEmpty()) {
            for (Human child : children) {
                res.append(child.getName());
                res.append(" ");
            }
            return res;
        }
        else {
            res.append("Нет");
        }
        return res;
    }

    public String getInfo() {
        return "ID человека: " + getId() +
               "\nID родителя: " + getFirstParent() +
               "\nИмя: " + getName() +
               "\nРодители: " + getFirstParent() + " " + getSecondParent() +
               "\nРодители: " + getSecondParent() +
               "\nДата рождения: " + getBirthday() +
               "\nДети: " + getChildren();
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return human.getHash() == getHash();
    }
}