import javax.lang.model.element.Name;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Gender gender;
    private Human wifeOrHusband;
    private LocalDate birthDay;
    




    public Human(String name, String surname, String patronymic, Human mother, Human father, List<Human> children,
            Gender gender, String sex, Human wifeOrHusband, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.gender = gender;
        this.wifeOrHusband = wifeOrHusband;
        this.birthDay = birthDay;
    }
    


    public Human(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.children = new ArrayList<>();
    }



    public Human(String name, String surname, String patronymic, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mother = mother;
        this.father = father;
    }



    public Human(String name, String surname, Gender gender, String sex) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
    
    public Human() {
        children = new ArrayList<>();
    }

    public void addChildren(Human human){
        this.children.add(human);
    }

    public List<Human> getChildren(){
        return children;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    @Override
    public String toString() {
        return "имя: " + name + ", фамилия: " + surname + ", отчество: " + patronymic;
    }
}



