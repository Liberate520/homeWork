package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private int age;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;




    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mather){
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.age = Period.between(dateOfBirth, dateOfDeath).getYears();
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mather != null){
            parents.add(mather);
        }
        children = new ArrayList<>();

    }
    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath){
        this(name,gender,dateOfBirth,dateOfDeath,null,null);
    }
    public Human getSpouse(){return  spouse;}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public LocalDate getDateOfDeath(){
        return dateOfDeath;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public List<Human> getParents(){
        return parents;
    }
    public List<Human> getChildren(){
        return children;
    }
    public boolean addParent(Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }
    public void setSpouse(Human spouse){this.spouse=spouse;}
    public String getSpouseInfo(){
        String res ="супруг(а): ";
        if (spouse==null){
            res+="нет";
        }else {
            res+=spouse.getName();
        }
        return res;
    }
    public boolean addChild (Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public  Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public  Human getMather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }
    public String getMotherInfo(){
        String res ="мать: ";
        Human mother = getMather();
        if (mother==null){
            res+="неизвестна";
        }else {
            res+=mother.getName();
        }
        return res;
    }
    public String getFatherInfo(){
        String res ="отец: ";
        Human father = getFather();
        if (father==null){
            res+="неизвестен";
        }else {
            res+=father.getName();
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size()!=0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", дата рождения: ");
        sb.append(getDateOfBirth());
        sb.append(", возраст: ");
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

    @Override
    public String toString() {
        return getInfo();
    }
}
