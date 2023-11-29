import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Human {
    private int id;

    private String name;
    private String lastname;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private Map<String, Human> parents;
    private List<Human> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public Human(String name, String lastname, Gender gender) {
        id++;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        Map<String, Human> parents = new HashMap<>();
        this.parents = parents;
        List<Human> children = new ArrayList<>();
        this.children = children;

    }

    public String getAge() {
        if (this.deathday == null) {
            return Integer.toString(Period.between(this.birthday, LocalDate.now()).getYears());
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(this.lastname);
            stringBuilder.append(" ").append(this.name).append(" умер(ла) в возрасте ");
            stringBuilder.append(Period.between(this.birthday, this.deathday).getYears());
            stringBuilder.append(" лет.");
            return stringBuilder.toString();
        }
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder("Дети: ");
        stringBuilder.append(this.children);
        return stringBuilder.toString();
    }


    public String getParents() {
        StringBuilder stringBuilder = new StringBuilder("Родители: ");
        stringBuilder.append(this.parents);
        return stringBuilder.toString();
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(LocalDate deathday) {this.deathday = deathday;}

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    private void setParent(Human human) {
        if (human.gender == Gender.Male) {
            this.parents.put("отец",human);
        }
        else this.parents.put("мать",human);
    }

    public void setChild(Human human) { // в main можно использовать только этот метод, т.к. он привязывает родителей автоматически
        this.children.add(human);
        human.setParent(this);
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {return "name: " + name + ", lastname: " + lastname + ", birthday: " + birthday + ", gender: " + gender  + ", children: " + children;}

}
