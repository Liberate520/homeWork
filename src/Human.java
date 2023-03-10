import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human extends Individual implements Serializable, Comparable<Human> {
    private String name;
    private Gender gender;
    private Integer birthYear;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender, Integer birthYear) {
        this(name, gender, birthYear, null, null);
    }

    public Human(String name, Gender gender, Integer birthYear, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human(String name2, String gender2, Integer yearofbirth2, String father2, String mother2) {
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthDate() {
        return birthYear;
    }

    public Gender getGender() {
        return gender;
    }

   

    @Override
    public String getInfo(){
        StringBuilder sb = new StringBuilder();        
        sb.append("name: ");
        sb.append(name);
        sb.append(", ");
        sb.append("born: ");
        sb.append(birthYear);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    
    private String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for(int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("no");
        }
        return res.toString();
    }
    
    
    
    // public String getInfo() {
    //     return String.format("Имя: %s; Пол: %s; Год рождения: %d; Отец: %s; Мать: %s.", name, gender, birthYear,
    //             getFatherInfo(), getMotherInfo());
    // }

    
    private String getFatherInfo(){
        String res = "father: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    private String getMotherInfo(){
        String res = "mother: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
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

    public void removeChild(Human human) {
        children.remove(human);
    }

    public void removeMother() {
        mother = null;
    }

    public void removeFather() {
        father = null;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

}
