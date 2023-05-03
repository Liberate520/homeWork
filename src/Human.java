import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, Serializable, HumanGroupItem {

    private int id;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private String name;
    private String surname;
    private String dateOfBirth;

    public Human(int id, String name, String surname, String dateOfBirth, Gender gender, Human father, Human mother,
            List<Human> children) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }
    
    public Human(int id, String name, String surname, String dateOfBirth, Gender gender, Human father, Human mother) {
        this(id, name, surname, dateOfBirth, gender, father, mother, null);
    }

    public Human(int id, String name, String surname, String dateOfBirth, Gender gender, List<Human> children) {
        this(id, name, surname, dateOfBirth, gender, null, null, children);
    }

    public Human(int id, String name, String surname, String dateOfBirth, Gender gender) {
        this(id, name, surname, dateOfBirth, gender, null, null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Human> getChildren() {
        List<Human> children = new ArrayList<>();

        return children;
    }

    public String getDateOfBirth() {
        
        return dateOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public String getInfoChildren(List<Human> children) {
        if (children == null) {
            return "not";
        }
        int count = children.size();
        if (count > 0) {
            String result = "";
            for (int i = 0; i < children.size() - 1; i++) {
                result += children.get(i).getName() + ", ";
            }
            result += children.get(children.size() - 1).getName();
            return result.replaceAll(", $", "");
        }
        return "not";
    }
    

    @Override
    public String toString() {
        return getInfo();
        // name + " " + surname + " Дата рождения: " + dateOfBirth + " Пол: " + gender +
        //          " Информация о родителях:  Отец: " + father + " Мать: " + mother +
        //          " Информация о детях:  " + getInfoChildren(children);
    }
    
    public boolean addChildren(Human human) {
        if (!children.contains(human)) {
            children.add(human);
            return true;
        }
        return false;
    }

    public String getMotherInfo() {
        String res = "mather: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }
    
    public String getFatherInfo() {
        String res = "father: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("ID: ");
        info.append(id);
        info.append(" - ");
        info.append("name: ");
        info.append(name);
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", children: ");
        info.append(getInfoChildren(children));
        info.append(". ");
        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }





}
