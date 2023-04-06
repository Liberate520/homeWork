import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable {

    private String name;
    private String surname;
    public Gender gender;
    private LocalDate birthday;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mother;
    private int humaID;
    private List<Human> children;
    private static int humanIDiterator = 1111;

    public Human(String name, String surname, LocalDate birthday, LocalDate dateOfDeath) {
        this(name, surname, null, birthday, null, null, dateOfDeath);
    }

    public Human(String name, String surname, LocalDate birthday) {
        this(name, surname, null, birthday, null, null, null);
    }

    public Human(String name, String surname, Gender gender, LocalDate birthday){
        this(name, surname, gender, birthday, null, null ,null);
    }
    public Human(String name, String surname, Gender gender, LocalDate birthday, LocalDate dateOfDeath){
        this(name, surname, gender, birthday, null, null ,dateOfDeath);
    }
    public Human(String name, String surname, Gender gender, LocalDate birthday, Human father, Human mother){
        this(name, surname, gender, birthday, father,mother,  null);
    }
    public Human(String name, String surname, Gender gender, LocalDate birthday, Human father, Human mother, LocalDate dateOfDeath) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        this.humaID = humanIDiterator;
        humanIDiterator += 1;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public Gender getGender() {return gender;}
    public LocalDate getBirthday() {return birthday;}
    public LocalDate getDateOfDeath() {return dateOfDeath;}
    public Human getFather() {return father;}
    public Human getMother() {return mother;}
    public List<Human> getChildren() {return children;}
    public int getHumanID() {return humanIDiterator;}

    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setGender(Gender gender) {this.gender = gender;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    public void setDateOfDeath(LocalDate dateOfDeath) {this.dateOfDeath = dateOfDeath;}
    public void setFather(Human father) {this.father = father;}
    public void setMother(Human mother) {this.mother = mother;}

    public String getInfoHuman(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "Имя: " + getName() + ", " + " Фамилия: " + getSurname() +  ", " + "  Дата рождения: " + getBirthday() + ", " + "  Номер в базе данных: " + humaID + ", ");
        if (!(getDateOfDeath() == null)){
            sb.append("  Дата смерти: " + getDateOfDeath());
        }
        return sb.toString();
    }

    public String getMotherInfo(){
        String moth = "Мать: ";
        if (mother != null){
            moth += mother.getInfoHuman();
        } else {
            moth += "неизвестна";
        }
        return moth;
    }
    public String getFatherInfo(){
        String fath = "Отец: ";
        if (father != null){
            fath += father.getInfoHuman();
        } else {
            fath += "неизвестен";
        }
        return fath;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getInfoHuman());
            for (int i = 1; i < children.size(); i++) {
                res.append(children.get(i).getInfoHuman());
            }
        }
        else {res.append("отсутсвуют");}
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Human)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members
        Human human = (Human) o;
        // Compare the data members and return accordingly
        return human.getName().equals(getName());
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
        }
        return false;
    }

    public boolean  addFather(Human father){
        if(this.father == null){
            this.father = father;
        }
        return false;
    }
    public void addMother(Human mother){
        if(this.mother == null){
            this.mother = mother;
        }
    }
}
