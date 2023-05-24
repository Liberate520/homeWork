package human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, FamilyTreeObject<Human>{
    private String firstName;
    private String lastName;
    private Calendar birthday = new GregorianCalendar();
    private Calendar dethhday = new GregorianCalendar(0,0,0);
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<Human>();

    public Human(String firstName, String lastName, Gender gender, int dayOfBirth, int monthOfBirth,
                int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday.set(Calendar.DAY_OF_MONTH, dayOfBirth);
        this.birthday.set(Calendar.MONTH, monthOfBirth);
        this.birthday.set(Calendar.YEAR, yearOfBirth);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String getFullName(){
        return (firstName+" "+lastName);
    }

    public String getBirthday(){
        if(birthday.get(Calendar.DAY_OF_MONTH) == 31 && birthday.get(Calendar.MONTH) == 11 &&
        birthday.get(Calendar.YEAR) == 2){
            return "Дата рождения неизвестна";
        } else{
            return (birthday.get(Calendar.DAY_OF_MONTH)+"."+birthday.get(Calendar.MONTH)+"."+birthday.get(Calendar.YEAR));
        }
    }
    @Override
    public Calendar getDateBirthday(){
        return birthday;
    }
    public String getDethday(){
        if(dethhday.get(Calendar.DAY_OF_MONTH) == 31 && dethhday.get(Calendar.MONTH) == 11 &&
        dethhday.get(Calendar.YEAR) == 2){
            return "Дата смерти неизвестна";
        } else{
            
            return (dethhday.get(Calendar.DAY_OF_MONTH)+"."+dethhday.get(Calendar.MONTH)+"."+dethhday.get(Calendar.YEAR));
        }
    }
    public Human getMother(){
            return mother;
    }
    public Human getFather(){
        return father;
    }

    public List<Human> getChildren(){
        return children;
    }
    public Gender getGender(){
        return gender;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setMother(Human mother) {
        if(mother.getGender()==Gender.Female){
            this.mother = mother;
            if (mother.children.indexOf(this)<0){
                mother.children.add(this);
            }
        }else{
            System.out.println("Мужчина не может быть мамой");
        }
    }
    public void setFather(Human father) {
        if(father.getGender()==Gender.Male){
            this.father = father;
            if (father.children.indexOf(this)<0){
                father.children.add(this);
            }
        }else{
            System.out.println("Женщина не может быть отцом");
        }
    }

    public void setBirthday(int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.birthday.set(Calendar.DAY_OF_MONTH, dayOfBirth);
        this.birthday.set(Calendar.MONTH, monthOfBirth);
        this.birthday.set(Calendar.YEAR, yearOfBirth);
    }

    public void setDethday(int dayOfDeth, int monthOfDeth, int yearOfDeth){
        this.dethhday.set(Calendar.DAY_OF_MONTH, dayOfDeth);
        this.dethhday.set(Calendar.MONTH, monthOfDeth);
        this.dethhday.set(Calendar.YEAR, yearOfDeth);
    }

    public void addChild(Human child){
        if (children.indexOf(child)<0){
            this.children.add(child);
        }
        if(this.getGender()==Gender.Male){
            child.setFather(this);
        }else {
            if(this.getGender()==Gender.Female){
            child.setMother(this);
        }
    }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " +", "+gender+", "+ birthday.get(Calendar.DAY_OF_MONTH)+"."+
                birthday.get(Calendar.MONTH)+"."+birthday.get(Calendar.YEAR)+" г.р.";
    }

    @Override
    public boolean equals(Object o){
        Human h = (Human) o;
        return (firstName == h.firstName && lastName == h.lastName && 
        birthday.get(Calendar.DAY_OF_MONTH) == h.birthday.get(Calendar.DAY_OF_MONTH) &&
        birthday.get(Calendar.MONTH) == h.birthday.get(Calendar.MONTH) &&
        birthday.get(Calendar.YEAR) == h.birthday.get(Calendar.YEAR));
    }

    @Override
    public int compareTo(Human o){
        return this.getFullName().compareTo(o.getFullName());
    }

}
