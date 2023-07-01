package homeWork.FamalyTree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private String last_name;
    private LocalDate DOB;
    private LocalDate DOD = null;
    private Gender gender;
    private Human mother = null, father = null;
    private List<Human> children;

    public Human(String name, String last_name, LocalDate DOB, LocalDate DOD, Gender gender, Human father, Human mother){
        id = -1;
        this.name = name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.DOD = DOD;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return last_name;
    }

    public LocalDate getDOB(){
        return DOB;
    }

    public LocalDate getDOD(){
        return DOD;
    }

    public Gender getGender(){
        return gender;
    }

    public String getFather(){
        String dad;
        if (father != null){
            dad = father.getName();
        }
        else{
             dad = "Нет данных";
        }
        return dad;
    }

    public String getMother(){
        String mam;
        if (mother != null){
            mam = mother.getName();
        }
        else{
             mam = "Нет данных";
        }
        return mam;
    }

    public String addChild (Human child){
        return child.getName();
    }
    
    public String getChildren(){
        StringBuilder child = new StringBuilder();
        if (children.size() == 0){
            child.append("нет");
        }
        else{
            for (int i = 0; i < children.size(); i++){
                child.append(children.get(i));
            }            
        }
        return child.toString();
    }

    public int getAge(){
        if (DOD == null){
            return getLifeAge(DOB, LocalDate.now());
        }
        else{
            return getLifeAge(DOB,DOD);
        }
        
    }

    public int getLifeAge(LocalDate DOB, LocalDate DOD){
        Period diff = Period.between(DOB, DOD);
        return diff.getYears();
    }

    @Override
    public String toString() {        
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", last name: ");
        sb.append(last_name);
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", father: ");
        sb.append(getFather());
        sb.append(", mother: ");
        sb.append(getMother());
        sb.append(", children: ");
        sb.append(getChildren());
        return sb.toString();
    }
    
}


