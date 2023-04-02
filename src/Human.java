import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Human {

    private String name;
    private String surname;
    private Gender gender;
    private Date birthday;
    private Date dateOfDeath;
    private Human father;
    private Human mother;
    private List<Human> children;
    private static int humanID = 1111;

    public Human(String name, String surname, Gender gender, Date birthday){
        this(name, surname, gender, birthday, null, null ,null);
    }
    public Human(String name, String surname, Gender gender, Date birthday, Date dateOfDeath){
        this(name, surname, gender, birthday, null, null ,dateOfDeath);
    }
    public Human(String name, String surname, Gender gender, Date birthday, Human father, Human mother){
        this(name, surname, gender, birthday, father,mother,  null);
    }
    public Human(String name, String surname, Gender gender, Date birthday, Human father, Human mother, Date dateOfDeath) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        ++humanID;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public Gender getGender() {return gender;}
    public Date getBirthday() {return birthday;}
    public Date getDateOfDeath() {return dateOfDeath;}
    public List<Human> getChildren() {return children;}
    public static int getHumanID() {return humanID;}

    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setGender(Gender gender) {this.gender = gender;}
    public void setBirthday(Date birthday) {this.birthday = birthday;}
    public void setDateOfDeath(Date dateOfDeath) {this.dateOfDeath = dateOfDeath;}
    public void setFather(Human father) {this.father = father;}
    public void setMother(Human mother) {this.mother = mother;}
    public void setChildren(List<Human> children) {this.children = children;}

    public String getInfoHuman(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: " + getName() + "," + "Фамилия: " + getSurname() + "Дата рождения: " + getBirthday());
        if (!(getDateOfDeath() == null)){
            sb.append("Дата смерти:" + getDateOfDeath());
        }
        return sb.toString();
    }

    public String getMotherInfo(){
        String moth = "Мать: ";
        if (mother != null){
            moth = mother.getName();
        } else {
            moth += "неизвестна";
        }
        return moth;
    }
    public String getFatherInfo(){
        String fath = "Отец: ";
        if (father != null){
            fath = father.getName();
        } else {
            fath += "неизвестен";
        }
        return fath;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0){
            for (int i = 0; i < children.size(); i++) {
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
        return
    }
    Human h = new Human("Andrey", "Petrov", Gender.gender.WOMAN, 1864-2-2);
}
