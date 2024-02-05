import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private  LocalDate deathDate;
    private Human parent1;
    private Human parent2;
    private Human married;

    private List<Human> children;


    public Human(String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        id = 0;
        this.name = name;
        this.gender = gender;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        children = new ArrayList<>();

    }


    public boolean addChild(Human child) {

        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {

        if (parent.getGender().equals(Gender.Male)) {
            setParent1(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setParent2(parent);

        }
        return true;
    }

    public void setParent1(Human parent1){
        this.parent1 = parent1;
    }

    public void setParent2(Human parent2){
        this.parent2 = parent2;
    }

    public Human getParent1() {
        return parent1;
    }

    public Human getParent2() {
        return parent2;
    }


    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (parent1 != null) {
            list.add(parent1);
        }
        if (parent2 != null) {
            list.add(parent2);
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public  int getAge() {
        if (deathDate == null) {
            getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
        return getPeriod(birthDate, LocalDate.now());
    }


    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children){this.children = children;}

    public Human getMarried(){ return married;}

    public  void setMarried(Human married){this.married = married;}

    public Gender getGender() {
        return gender;
    }




    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(id);
        sb.append(", Имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(getMarriedInfo());
        sb.append(" ");
        sb.append(" ");
        sb.append(getParent1Info());
        sb.append(" ");
        sb.append(getParent2Info());
        sb.append(" ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }

    public  String getMarriedInfo(){
        String res = ", Брак:";
        if (married == null){
            res+= ", Нет";
        } else {
            res += married.getName();
        }
        return res;
    }

    public String getParent1Info() {
        String res = ", Отец:";
        if (parent1 == null) {
            res += ", нет";
        } else {
            res += parent1.getName();
        }
        return res;
    }



    public String getParent2Info() {
        String res = ", Мать:";
        if (parent2 == null) {
            res += ", нет";
        } else {
            res += parent2.getName();
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append(", Дети:");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(",");
                res.append(children.get(i).getName());
            }
        } else {
            res.append(",отсутствуют.");
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
