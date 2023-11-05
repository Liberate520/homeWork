import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private final Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private final List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        this(name, gender, birthDate, null, father, mother);
    }
    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }
    public void setFather (Human father) {this.father = father;}
    public void setMother (Human mother) {this.mother = mother;}
    public Human getFather () {return father;}
    public Human getMother () {return mother;}
    public List<Human> getParents () {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }
    public int getAge () {
        if (deathDate == null) {
            return getPeriod (birthDate, LocalDate.now());
        }else {
            return getPeriod (birthDate, deathDate);
        }
    }
    private int getPeriod ( LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public  void setSpouse (Human spouse) {this.spouse = spouse;}
    public  Human getSpouse () {return spouse;}
    public  void setId (long id) {this.id = id;}
    public  long getId () {return id;}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public LocalDate getBirthDate () {return birthDate;}
    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}
    public LocalDate getDeathDate () {return deathDate;}
    public List<Human> getChildren() {return children;}
    public Gender getGender() {return gender;}

    @Override
    public String toString() {return getInfo();}
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" , Имя: ");
        sb.append(name);
        sb.append(" , пол: ");
        sb.append(getGender());
        sb.append(" , возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getSpouseInfo() {
        String res = "супруг(а): ";
       if (spouse == null) {res += "нет";}
       else {res += spouse.getName();}
       return res;
    }
    public String getMotherInfo() {
        String res = "мать: ";
        if(mother != null) {res += mother.getName();}
        else {res += "неизвестна";}
        return res;
    }
    public String getFatherInfo() {
        String res = "отец: ";
        if(father != null) {res += father.getName();}
        else {res += "неизвестен";}
        return res;
    }
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(" , ");
                res.append(children.get(i).getName());
            }
        } else {res.append("отсутствуют");}
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return  true;}
        if (!(obj instanceof Human)) {return false;}
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
