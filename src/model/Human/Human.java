package Human;
import javax.lang.model.element.Name;

import Tree.TreeCommon;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Human implements Comparable<Human>,Serializable, TreeCommon<Human> {
    private String name;
    private String surname;
    private String patronymic;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Gender gender;
    private Human wifeOrHusband;
    private LocalDate birthDay;
    private LocalDate deathDate;
    




    public Human(String name, String surname, String patronymic, Human mother, Human father, List<Human> children,
            Gender gender, Human wifeOrHusband, LocalDate birthDay, LocalDate deathDate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        this.gender = gender;
        this.wifeOrHusband = wifeOrHusband;
        this.birthDay = birthDay;
        this.deathDate = deathDate;
    }
    


    public Human(String name, String surname, String patronymic) {
        this(name, surname, patronymic, null, null, null, null, null, null, null);
        children = new ArrayList<>();
    }



    public Human(String name, String surname, String patronymic, Human mother, Human father) {
        this(name, surname, patronymic, mother, father, null, null, null, null, null);
        children = new ArrayList<>();
    }

    public Human(String name, String surname, Gender gender) {
        this(name, surname, null, null, null, null, gender, null, null, null);
        children = new ArrayList<>();
    }
    

    public void addChildren(Human child){
        this.children.add(child);
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
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append("Фамилия: ");
        sb.append(surname);
        sb.append("Отчество: ");
        sb.append(patronymic);
        return sb.toString();

    }
    public int getAge() {
        LocalDate birth = birthDay;
        LocalDate now = LocalDate.now();
        int age = (int) ChronoUnit.YEARS.between(birth, now);
        return age;
    }
    
    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}



