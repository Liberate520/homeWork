package oop_homework_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> children;
    private List<Human> bro;
   

    public Human(String surname, String patronymic, String name, Calendar dateOfBirth, Calendar dateOfDeath, Human mother, Human father, List<Human> children, List<Human> bro) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.bro = bro;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(Calendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public List<Human> getChildren() {
        return children;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public void setBro(List<Human> bro) {
        this.bro = bro;
    }
    public List<Human> getBro() {
        return bro;
    }    

    public String getFio() {
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public String toString() {
        String str = null;
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        str = surname + " " + name + " " + patronymic  + "\n" 
            + "Дата рождения: " + df.format(dateOfBirth.getTime()) + "\n";

        if (dateOfDeath.get(Calendar.YEAR) != 2) {
            str = str + "Дата смерти: " + df.format(dateOfDeath.getTime()) + "\n";
        }
       
        if (father != null){        
            str = str + "Отец: " + father.getFio() + "\n";
        }

        if (mother != null){
            str = str + "Мать: " + mother.getFio() + "\n";
        }

        if (!bro.isEmpty()){
            str = str + "Братья/сестры:\n";
            for (int i = 1; i < bro.size() + 1; i++) {
                str = str + i + ". " + bro.get(i - 1).getFio() + "\n";
            }            
        } 
        
        if (!children.isEmpty()){
            str = str + "Дети:\n";
            for (int i = 1; i < children.size() + 1; i++) {
                str = str + i + ". " + children.get(i - 1).getFio() + "\n";
            }            
        } 
                    
        return str;
    }

    
}
