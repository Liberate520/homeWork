package homeWork.tree;

import java.time.LocalDate;

public class Human {
    private String name;
    private String gender;
    private LocalDate birthday;
    private Boolean alive;
    private Boolean childfree;


    public Human(String name, String gender, LocalDate birthday, Boolean alive, Boolean childfree) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.alive = alive;
        this.childfree = childfree;
    }


    @Override
    public String toString() {
        if (alive) {
            return this.getName() + " age " + this.getAge();
        } else return name + ", died";
    };

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Boolean getAlive() {
        return alive;
    }

    public Boolean getChildfree(){
        return childfree;
    }

    public Integer getAge() {
        if(this.getAlive()){
            int yearBirth = this.birthday.getYear();
            int currentDate = LocalDate.now().getYear();
            return currentDate - yearBirth;
        }else return -1;
    }
}


