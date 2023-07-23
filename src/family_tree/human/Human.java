package family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthData;
    private LocalDate deadData;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthData, LocalDate deadData, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthData = birthData;
        this.deadData = deadData;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthData){
        this(name, gender, birthData, null, null, null);
    }

    public Human(String name, Gender gender,LocalDate birthData, Human mother, Human father){
        this(name, gender, birthData, null,  mother, father);
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deadData == null){
            return getPeriod(birthData, LocalDate.now());
        }
        return getPeriod(birthData, deadData);
    }

    private int getPeriod(LocalDate birthData, LocalDate deadData){
        Period diff = Period.between(deadData, birthData);
        return diff.getYears();
    }

    public void setId(long id){this.id = id;}
    public long getId() {return id;}
    public void setName(){this.name = name;}
    public String getName(){return name;}
    public void setGender(){this.gender = gender;}
    public Gender getGender(){return gender;}
    public void setBirthData(LocalDate birthData){this.birthData = birthData;}
    public LocalDate getBirthData(){return birthData;}
    public void setDeadData(LocalDate deadData){this.deadData = deadData;}
    public LocalDate getDeadData(){return deadData;}
    public List<Human> getParents(){return parents;}
    public List<Human> getChildren(){return children;}

    public String getMotherInfo(){
        String res = "мать ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизыестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0 ){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсуствуют");
        }
        return res.toString();
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
        return human.getId() == getId();
    }

    public String getInfo(){
        StringBuilder str = new StringBuilder();
        str.append("id: ");
        str.append(id);
        str.append(" | имя: ");
        str.append(name);
        str.append(" | пол: ");
        str.append(getGender());
        str.append(" | возраст: ");
        str.append(getAge());
        str.append(" | ");
        str.append(getMotherInfo());
        str.append(" | ");
        str.append(getFatherInfo());
        str.append(" | ");
        str.append(getChildrenInfo());
        return str.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
