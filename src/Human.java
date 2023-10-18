import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private  int id;
    private int first_parent_id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String second_parent;
    private int hash;
    private List<Human> children = new ArrayList<>();

    public Human(int id, int first_parent_id, String name, LocalDate birthday, Gender gender, String second_parent, int hash) {
        this.id = id;
        this.first_parent_id = first_parent_id;
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

    public void setHash() {
        this.hash = hash;
    }

    public int getFirstParent() {
        return first_parent_id;
    }

    public void setFirstParent(int first_parent_id) {
        this.first_parent_id = first_parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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
        if (children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                res.append(children.get(i).getName());
                res.append(" ");
            }
            return res;
        }
        else {
            res.append("Нет");
        }
        return res;
    }

//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }

    public String getInfo() {
        return "ID человека: " + getId() +
               "\nID родителя: " + getFirstParent() +
               "\nИмя: " + getName() +
//               "\nРодители: " + getFirstParent() + " " + getSecondParent() +
               "\nРодители: " + getSecondParent() +
               "\nДата рождения: " + getBirthday() +
               "\nДети: " + getChildren();
    }
//    public String getFirstParent(int first_parent_id) {
//        Iterable<? extends Human> humanList = null;
//        for (Human k: humanList) {
//            if (k.getFirstParent() == first_parent_id) return k.name;
//        }
//        return null;
//    }

    public boolean AddChild(Human child) {
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