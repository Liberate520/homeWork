package members;

import java.io.Serializable;

import tree_structure.Subject;

public class Dog implements Serializable, Comparable<Dog>, Subject{
    private int id;
    private String name;
    private Boolean gender;
    private int father_id;
    private int mother_id;
    private int birthday_date;
    
    public Dog(String name, Boolean gender, int birthday_date){
        this.name = name;
        this.gender = gender;
        this.birthday_date = birthday_date;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public Boolean getGender(){
        return gender;
    }

    public int getFather_id(){
        return father_id;
    }

    public int getMother_id(){
        return mother_id;
    }


    public String getName() {
        return name;
    }


    public Integer getBirthday_date(){
        return birthday_date;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", birth date: " + birthday_date;
    }

    @Override
    public int compareTo(Dog o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
