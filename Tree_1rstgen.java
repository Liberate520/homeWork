package Семинар1.homeWork;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;

public class Tree_1rstgen {
    protected String firstname;
    protected String lastname;
    protected String birth_date;
    protected String deth_date;
    protected String gender;
    protected String person_id;
    protected String child_id;
    
    public Tree_1rstgen(String inp_firstname, String inp_lastname, String inp_birth_date, String inp_deth_date, String inp_gender, String inp_person_id, String inp_child_id){
        this.firstname = inp_firstname;
        this.lastname = inp_lastname;
        this.birth_date = inp_birth_date;
        this.deth_date = inp_deth_date;
        this.gender = inp_gender;
        this.person_id = inp_person_id;
        this.child_id = inp_child_id;
        
    }
    public Tree_1rstgen(String inp_firstname, String inp_lastname, String inp_birth_date, String inp_gender, String inp_person_id){
        this(inp_firstname, inp_lastname, inp_birth_date, null, inp_gender, inp_person_id, null);
        
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
    
    public String getChild_id() {
        return child_id;
    }
    public void setChild_id(String child_id) {
        this.child_id = child_id;
    }
    public String getgender() {
        return gender;
    }
    public String getBirthDate() {
        return birth_date;
    }

    public void age(Tree_1rstgen person){
        java.util.Date dateNow = new java.util.Date();
        DateFormat formater = new SimpleDateFormat("y");
        Integer year = Integer.parseInt(formater.format(dateNow));
        Integer b_year = Integer.parseInt(person.getBirthDate().substring(6,10));
        Integer res_age = year - b_year;
        System.out.println(res_age);

    }
    
}