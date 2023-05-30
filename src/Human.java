import org.xml.sax.SAXNotRecognizedException;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthdate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;

    private List<Human> children;
    private List<Human> brother;
    private List<Human> sister;

    public Human(String name, Gender gender, LocalDate birthdate) { this(name, birthdate, null, gender, null, null);}

    public Human(String name, LocalDate birthdate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthdate = birthdate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        brother = new ArrayList<>();
        sister = new ArrayList<>();
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return  false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    public Integer getAge(LocalDate birthdate, LocalDate deathDate){
       int age = Period.between(birthdate, LocalDate.now()).getYears();
       if(deathDate == null){
           return age;
       } else {
           int yearsBeforeDeath = Period.between(birthdate,deathDate).getYears();
           return  yearsBeforeDeath;
       }
   }

   public String getName(){ return  name;}

    public Human getFather(){ return father;}

    public Human getMother() { return mother;}

    public List<Human> getChildren() { return children;}

    public List<Human> getBrother() { return brother;}

    public List<Human> getSister() { return sister;}

    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate;}

    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate;}

    public void setFather(Human father) { this.father = father;}

    public void setMother(Human mother) { this.mother = mother;}

    public Gender getGender() { return gender;}
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(" Пол: ");
        sb.append(getGender());
        sb.append(" возраст: ");
        sb.append(getAge(birthdate, deathDate));
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        sb.append(getBrotherInfo());
        sb.append(", ");
        sb.append(getSisterInfo());
        return sb.toString();
    }

    private String getSisterInfo() {
        StringBuilder res = new StringBuilder();
        res.append("сестры: ");
        if(sister.size() >= 1){
            res.append(sister.get(0).getName());
            for (int i = 1; i < sister.size(); i++) {
                res.append(", ");
                res.append(sister.get(i).getName());
            }
        } else if (sister.size() == 1) {
            res.append(sister.get(0).getName());
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    private String getBrotherInfo() {
        StringBuilder res = new StringBuilder();
        res.append("братья: ");
        if(brother.size() >= 1){
            res.append(brother.get(0).getName());
            for (int i = 1; i < brother.size(); i++) {
                res.append(", ");
                res.append(brother.get(i).getName());
            }
        } else if (brother.size() == 1) {
            res.append(brother.get(0).getName());
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if(father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res = "неизвестна";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() >= 1){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else if (children.size() == 1) {
            res.append(children.get(0).getName());
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }
}
