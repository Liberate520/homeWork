import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

    private String firstname;
    private String lastname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;
    private List<Human> brothers;
    private List<Human> sisters;


    public Human(String firstName, String lastname, Gender gender, LocalDate birthDate) {
        this(firstName, lastname, gender, birthDate, null, null, null);
    }

    public Human(String firstName, String lastname, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.firstname = firstName;
        this.lastname = lastname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        brothers = new ArrayList<>();
        sisters = new ArrayList<>();
    }

    public Human(String firstName, String lastname, Gender gender, Human father, Human mother) {
        this(firstName, lastname, gender, null, null, father, mother);
    }


    public String getFirstName() { return firstname; }
    public String getLastName() { return lastname;  }
    public Gender getGender() { return gender;  }
    public Human getFather() { return father; }
    public Human getMother() { return mother; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public List<Human> getChildren() { return children; }
    public List<Human> getBrothers() { return brothers; }
    public List<Human> getSisters() { return sisters; }


    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setFather(Human father) { this.father = father; }
    public void setMother(Human mother) { this.mother = mother; }
    public void setChildren(List<Human> children) { this.children = children;  }
    public void setBrothers(List<Human> brothers) { this.brothers = brothers; }
    public void setSisters(List<Human> sisters) { this.sisters = sisters; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate; }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstname);
        sb.append(", ");
        sb.append("Фамилия: ");
        sb.append(lastname);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        sb.append(getBrothersInfo());
        sb.append(", ");
        sb.append(getSistersInfo());
        return sb.toString();
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += father.getFirstName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

      public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += mother.getFirstName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getFirstName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getFirstName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getBrothersInfo(){
        StringBuilder res = new StringBuilder();
        res.append("братья: ");
        if (brothers.size() != 0){
            res.append(brothers.get(0).getFirstName());
            for (int i = 1; i < brothers.size(); i++) {
                res.append(", ");
                res.append(brothers.get(i).getFirstName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getSistersInfo(){
        StringBuilder res = new StringBuilder();
        res.append("сёстры: ");
        if (sisters.size() != 0){
            res.append(sisters.get(0).getFirstName());
            for (int i = 1; i < sisters.size(); i++) {
                res.append(", ");
                res.append(sisters.get(i).getFirstName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }


  
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getFirstName().equals(getFirstName());
    }

}
