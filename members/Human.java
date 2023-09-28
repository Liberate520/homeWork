package members;

import java.io.Serializable;

public class Human implements Serializable{
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private Boolean gender;
    private int father_id;
    private int mother_id;
    private String birthday_date;
    private String birth_place;
    /*private String siblings;
    private String children;
    private Boolean alive_status;  */

    public Human(String name, String surname, String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
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

    public String getBirth_place(){
        return birth_place;
    }

    public String getBirthday_date(){
        return birthday_date;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", surname: " + surname + ", patronymic" + patronymic;
    }

}   
