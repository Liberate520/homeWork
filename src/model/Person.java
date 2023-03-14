package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Person implements Serializable{
    private String name;
    private String sex;
    private Date DateOfBirth;
    private Date DateOfDeath;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;


    public Person (String name, String sex, Date DateOfBirth, Date DateOfDeath,Person mother, Person father){
        this.name = name;
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.DateOfDeath = DateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Person>();
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
 
    public void setFather(Person father) {
        this.father = father;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(Person chil) {
        this.children.add(chil) ;
    }
    public void delChild(Integer chil) {
        if (this.children.size()>chil){
            if (this.sex=="male") this.children.get(chil).setFather(null);
            if (this.sex=="female") this.children.get(chil).setMother(null);
            System.out.println(chil+"========");
            this.children.remove(this.children.get(chil));
            System.out.println(chil+"========");
        }
        
    }
    // public Boolean verificationChild(Person chil) {
    //     for (Person person : this.children) {
    //         if (person.equals(chil)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public Person SearchChild(Integer chil) {
        for (Person person : this.children) {
            if (person.equals(chil)){
                return person;
            }
        }
        return null;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public String сhildrentoSring() {
        Integer count=0;
        String str="Нет такого персонажа";
        if (this.children != null){
            str="";
            while (count<this.children.size()){
                str=str+"\n"+(++count).toString()+". "+this.children.get(count-1);
           }
        }
        return str;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }
    public Date getDateOfDeath() {
        return DateOfDeath;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }
    public ArrayList<Person> getChildren() {
        return children;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((DateOfBirth == null) ? 0 : DateOfBirth.hashCode());
        result = prime * result + ((DateOfDeath == null) ? 0 : DateOfDeath.hashCode());
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
        if (DateOfBirth == null) {
            if (other.DateOfBirth != null)
                return false;
        } else if (!DateOfBirth.equals(other.DateOfBirth))
            return false;
        if (DateOfDeath == null) {
            if (other.DateOfDeath != null)
                return false;
        } else if (!DateOfDeath.equals(other.DateOfDeath))
            return false;
        return true;
    }
    
}