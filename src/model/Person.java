package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
// import java.util.List;

public class Person implements Serializable{
    private String name;
    private String sex;
    private Date DateOfBirth;
    private Date DateOfDeath;
    private Person mother;
    private Person father;
    // private Person curPerson;
    private ArrayList<Person> children;


    public Person (String name, String sex, Date DateOfBirth, Date DateOfDeath,Person mother, Person father){
        this.name = name;
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.DateOfDeath = DateOfDeath;
        this.mother = mother;
        this.father = father;
    }
    public Person (String name, String sex, Date DateOfBirth,Person mother, Person father){
        this(name, sex, DateOfBirth, null,mother, father);
    }
    public Person (){
        this("Unkown", "Unkown", null, null, null, null);
    }    
    public Person (String name, String sex, Date DateOfBirth){
        this(name, sex, DateOfBirth, null,null, null);
    }

    public String toString(){
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String rez="Person "+ "name ='" + name + "' пол ='" + sex +  "'";
        // sdf.parse(DateOfBirth.toString());
        if(DateOfBirth!=null) rez=rez+" Дата рождения - " + DateOfBirth.toString() ;
        if(DateOfDeath!=null) rez=rez+" Дата смерти - " + DateOfDeath.toString() ;
        if(mother!=null) rez=rez+" Мать - " + mother.getName() ;
        if(father!=null) rez=rez+" Отец - " + father.getName() ;
        return rez;
    }
    //печать списка персон
    public static void printListPerson(ArrayList<Person> listPerson){
        Integer count=0;
        while (count<listPerson.size()){
            System.out.println(++count+". "+listPerson.get(count-1));
                // count++;
        }
    }

    public String getSex() {
        return sex;
    }
    public String getName() {
        return name;
    }
    //
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
    public void setDateOfDeath(Date dateOfDeath) {
        DateOfDeath = dateOfDeath;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }
    public void setFather(Person father) {
        this.father = father;
    }
    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }
}