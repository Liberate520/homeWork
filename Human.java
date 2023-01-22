package Семинар1.homeWork;

import java.io.Serializable;
import java.util.List;

// Сделать наследованием от первого класса
public class Human  implements Serializable, Comparable<Human>{
    private String firstname;
    private String lastname;
    private String birth_date;
    private String deth_date;
    private String gender;
    private String person_id;
    private String father_id;
    private String mother_id;
    List<Human> family;

    
    
    public Human(String inp_firstname, 
                       String inp_lastname, 
                       String inp_birth_date, 
                       String inp_deth_date, 
                       String inp_gender, 
                       String inp_person_id, 
                       String inp_father_id, 
                       String inp_mother_id){

        this.firstname = inp_firstname;
        this.lastname = inp_lastname;
        this.birth_date = inp_birth_date;
        this.deth_date = inp_deth_date;
        this.gender = inp_gender;
        this.person_id = inp_person_id;
        this.father_id = inp_father_id;
        this.mother_id = inp_mother_id;

    }
    public Human(String inp_firstname, String inp_lastname, String inp_birth_date, String inp_gender, String inp_person_id){
        this(inp_firstname, inp_lastname, inp_birth_date, null, inp_gender, inp_person_id, null, null);

    }
    // Нужно прописать способ, чтобы null проставлялся как  - и изучить формат даты, в том числе, как их в f-строку записывать
    @Override
    public String toString() {
        return String.format("Имя: %s\nФамилия: %s\nДата рождения: %s\nДата смерти: %s\nПол: %s\n", firstname, lastname, birth_date, deth_date, gender);
    }

    public String getPerson_id() {
        return person_id;
    }
    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }
    public String getgender() {
        return gender;
    }
    public void setgender(String gender) {
        this.gender = gender;
    }
    public String getBirthDate() {
        return birth_date;
    }
    public void setBirthDate(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getDethDate() {
        return deth_date;
    }
    public void setDethDate(String deth_date) {
        this.deth_date = deth_date;
    }

    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public String getFather_id() {
        return father_id;
    }
    public void setFather_id(String father_id) {
        this.father_id = father_id;
    }

    public String getMother_id() {
        return mother_id;
    }
    public void setMother_id(String mother_id) {
        this.mother_id = mother_id;
    }
    @Override
    public int compareTo(Human o) {
        
        return lastname.compareTo(o.lastname);
    }
    
    
    
    
    



     
}
    