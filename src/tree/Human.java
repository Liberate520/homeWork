package tree;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Human implements Serializable, Comparable<Human>{
    private String name;
    private String surname;
    private String patronymic;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> children;
    private List<Human> bro;
   
    public Human(String surname, String patronymic, String name, Calendar dateOfBirth, Calendar dateOfDeath) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;    
        this.father = null;
        this.mother = null; 
        children = new ArrayList<>();
        bro = new ArrayList<>(); 
    }

    public Human(String surname, String patronymic, String name, Calendar dateOfBirth, Calendar dateOfDeath, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mother = mother;
        this.father = father;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        children = new ArrayList<>();
        bro = new ArrayList<>();
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

    public String getDateOfBirthString() {
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        return df.format(dateOfBirth.getTime());
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
    public void setChildren(Human human) {
        if(!children.contains(human)){
            this.children.add(human);
        } 
    }
    public void setBro(Human human) {
        if(!children.contains(human)){
            this.children.add(human);
        } 
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

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (patronymic == null) {
            if (other.patronymic != null)
                return false;
        } else if (!patronymic.equals(other.patronymic))
            return false;
        return true;
    }

    public void add(Human human) {
    }

    public boolean contains(Human human) {
        return false;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

  

    

    

    
}
