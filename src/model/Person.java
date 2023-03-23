package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Person implements Serializable{
    transient private static AtomicInteger idCounter=new AtomicInteger(0);
    private int id;
    private String name;
    private String sex;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;


    public Person (String name, String sex, Date dateOfBirth, Date dateOfDeath,Person mother, Person father){
        this.id=idCounter.addAndGet(1);
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Person>();
    }
    public Person (String name, String sex, Date dateOfBirth,Person mother, Person father){
        this(name, sex, dateOfBirth, null,mother, father);
    }
    public Person (){
        this("Unkown", "Unkown", null, null, null, null);
    }    
    public Person (String name, String sex, Date dateOfBirth){
        this(name, sex, dateOfBirth, null,null, null);
    }

    public String toString(){
        String rez="Person "+id+ " name ='" + name + "' пол ='" + sex +  "'";
        if(dateOfBirth!=null) rez=rez+" Дата рождения - " + dateOfBirth.toString() ;
        if(dateOfDeath!=null) rez=rez+" Дата смерти - " + dateOfDeath.toString() ;
        if(mother!=null) rez=rez+" Мать - " + mother.getName() ;
        if(father!=null) rez=rez+" Отец - " + father.getName() ;
        return rez;
    }

    public String getSex() {
        return sex;
    }
    public String getName() {
        return this.name;
    }
    public Integer getId() {
        return this.id;
    }
    //
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
 
    public void setFather(Person father) {
        this.father = father;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(Person chil) {
        if (!this.children.contains(chil)){
            this.children.add(chil);
        }
    }

    public void delChild(Integer chil) {
        if (this.children.size()>chil){
            if (this.sex.equals("male")){
                this.children.get(chil).setFather(null);
            } 
            if (this.sex.equals("female"))  {
                this.children.get(chil).setMother(null);
            }
            this.children.remove(this.children.get(chil));
        }
        
    }

    public String сhildrentoSring() {
        Integer count=0;
        String str="Детей нет";
        if (!this.children.isEmpty()){
            str="";
            while (count<this.children.size()){
                str=str+"\n"+(++count).toString()+". "+this.children.get(count-1);
           }
        }
        return str;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public Date getDateOfDeath() {
        return dateOfDeath;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((dateOfDeath == null) ? 0 : dateOfDeath.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (dateOfDeath == null) {
            if (other.dateOfDeath != null)
                return false;
        } else if (!dateOfDeath.equals(other.dateOfDeath))
            return false;
        return true;
    }
    
}