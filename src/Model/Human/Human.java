package Model.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import Model.FamilyTree.FamilyItem;

public class Human implements Serializable,FamilyItem<Human>{
    private long id;
    private String name;
    private String gender;
    private LocalDate dateOfBirth; 
    private LocalDate dateOfDeath; 
    private List<Human> parents;
    private List<Human> children;  
    private Human spouse;

    public Human(String name, String gender,LocalDate dateOfBirth,
    LocalDate dateOfDeath,Human father,Human mother){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if(father!=null){
            parents.add(father);
        }
        if(mother!=null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, String gender,LocalDate dateOfBirth,Human father,Human mother){
        this(name, gender, dateOfBirth, null, father, mother);
    }

    public Human(String name, String gender,LocalDate dateOfBirth){
        this(name, gender, dateOfBirth, null, null, null);
    }
  
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath){
        this.dateOfDeath = dateOfDeath;
    }

    public LocalDate getDateOfDeath(){
        return dateOfDeath;
    }

    private int getPeriod(LocalDate dateOfBirth,LocalDate dateOfDeath){
        Period diff = Period.between(dateOfBirth, dateOfDeath);
        return diff.getYears();
    }

    public int getAge(){
        if(dateOfDeath==null){
            return getPeriod(dateOfBirth, LocalDate.now());
        }
        else{
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        else{
            return false;
        }
    }

    public List<Human> getChildren(){
        return children;
    }

    public boolean addFather(Human father){
        if(father.getGender().equalsIgnoreCase("male")&&parents.size()<2){
            parents.add(father);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addMother(Human mother){
        if(mother.getGender().equalsIgnoreCase("female")&&parents.size()<2){
            parents.add(mother);
            return true;
        }
        else{
            return false;
        }
    }

    public Human getFather(){
        for(Human father: parents){
            if(father.getGender().equalsIgnoreCase("male")){
                return father;
            }
        }
        return null;
    }

    public Human getMother(){
        for(Human mother: parents){
            if(mother.getGender().equalsIgnoreCase("female")){
                return mother;
            }
        }
        return null;
    }

    public List<Human> getParents(){
        return parents;
    }

    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }

    public Human getSpouse(){
        return spouse;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public String getFatherInfo(){
        if(getFather()!=null){
            return getFather().getName();
        }
        return "absent";
    }

    public String getMotherInfo(){
        if(getFather()!=null){
            return getMother().getName();
        }
        return "absent";
    }

    public String getChildrenInfo(){
        List<String> childrenNames = new ArrayList<>();
        if(!children.isEmpty()){
            for(Human child: children){
                childrenNames.add(child.getName());
            }
        } 
        else{
            childrenNames.add("absent");
        }
        return childrenNames.toString();
    }

    public String getSpouseInfo(){
        if(spouse!=null){
            return spouse.getName();
        }
        else{
            return "absent";        }
    }

    public String toString(){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("id: ");
        sBuilder.append(getId());
        sBuilder.append("; name: ");
        sBuilder.append(name);
        sBuilder.append("; gender: ");
        sBuilder.append(gender);
        sBuilder.append("; Age: ");
        sBuilder.append(getAge());
        sBuilder.append("; father: ");
        sBuilder.append(getFatherInfo());
        sBuilder.append("; mother: ");
        sBuilder.append(getMotherInfo());
        sBuilder.append("; children: ");
        sBuilder.append(getChildrenInfo());
        sBuilder.append("; spouse: ");
        sBuilder.append(getSpouseInfo());
        sBuilder.append("\n");
        return sBuilder.toString();
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human)obj;
        boolean eqName = getName().equalsIgnoreCase(human.getName());
        boolean eqGender = getGender().equalsIgnoreCase(human.getGender());
        boolean eqBirth = getDateOfBirth().equals(human.getDateOfBirth());
        boolean eqAge = getAge()==human.getAge();
        return eqName&&eqGender&&eqBirth&&eqAge;    
    }
}
