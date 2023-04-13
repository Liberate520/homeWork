import java.util.List;

public class Person {  
    
    private Gender gender;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birth;
    private Date death;
    private Person father;
    private Person mother;
    private Person wife;
    private Person husband;
    List<Person> children; 

   

public Person(Gender gender, String firstName, String middleName, String lastName, Date birth) {
        this.gender = gender;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birth = birth;
        this.death = death;
        this.father = father;
        this.mother = mother;
        this.wife = wife;
        this.husband = husband;
        this.children = children;
        

        }


public Gender getGender() {
    return gender;
}
public void setGender(Gender gender) {
    this.gender = gender;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public String getMiddleName() {
    return middleName;
}
public void setMiddleName(String middleName) {
    this.middleName = middleName;
}
public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public Date getBirth() {
    return birth;
}
public void setBirth(Date birth) {
    this.birth = birth;
}
public Date getDeath(){
    return death;
}
public void setDeath(Date death){
    this.death = death;
}
public Person getFather() {
    return father;
    
}
public void setFather(Person father) {
    this.father = father;

}
public Person getMother() { 
    
    return mother;
}
public void setMother(Person mother) {
    
    this.mother = mother;
}
public Person getWife() {
    
    return wife;
}
public void setWife(Person wife) {
    this.wife = wife;
}
public Person getHusband() {
    
    return husband;
}
public void setHusband(Person husband) {
    
    this.husband = husband;
}
public List<Person> getChildren() {
    
    return children;
}
public void setChildren(List<Person> children) {

    this.children = children;
} 




@Override

public String toString(){

    return  gender+", "+firstName+" "+middleName+" "+lastName+", "+birth;
    
   
}


} 



