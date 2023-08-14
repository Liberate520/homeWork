package Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dateBirthday;
    private LocalDate dateDeath;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;


    public Human(String name, Gender gender, LocalDate dateBirthday, LocalDate dateDeath,
                 Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.dateBirthday = dateBirthday;
        this.dateDeath = dateDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate dateBirthday) {
        this(name, gender, dateBirthday, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate dateBirthday,
                 Human father, Human mother) {
        this(name, gender, dateBirthday, null, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParents(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (dateDeath == null) {
            return getPeriod(dateBirthday, LocalDate.now());
        } else {
            return getPeriod(dateBirthday, dateDeath);
        }
    }

    private int getPeriod(LocalDate dateBirthday, LocalDate dateDeath) {
        Period diff = Period.between(dateBirthday, dateDeath);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateBirthday() {
        return dateBirthday;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", spouse: ");
        sb.append(getSpouse());
        sb.append(", parents: ");
        sb.append(getParents());
        sb.append(", children: ");
        sb.append(getChildren());
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "Супруг/а: ";
        if(spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if(mother != null){
            res += getMother().getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if(father != null){
            res += getFather().getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if(children.size() != 0){
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
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
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
