package HomeWork.familyTree.homeWork22_10_23.src.human;

import HomeWork.familyTree.homeWork22_10_23.src.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Конструктор
 * */
public class Human {
   private String name;
   private LocalDate birthDay;



    private LocalDate dayOfDeath;
   private Gender gender;
   private Parent parent;



    private List<Children>childrenList = new ArrayList<>();
    private List<Human>parentList = new ArrayList<>();



    /**
     * @param name       имя
     * @param birthDay   день рождения
     * @param dayOfDeath день смерти
     * @param gender     пол
     * @param parent     энум  father, mom, baby;
     */
    public Human(String name, LocalDate birthDay, LocalDate dayOfDeath, Gender gender, Parent parent) {
        this.name = name;
        this.birthDay = birthDay;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        this.parent = parent;
    }

    /**
     *
     * @param name          имя
     * @param birthDay      день рождения
     * @param dayOfDeath    день смерти
     * @param gender        пол
     */
    public Human(String name, LocalDate birthDay, LocalDate dayOfDeath, Gender gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setChildrenList(Children children) {
        childrenList.add(children);
    }

    public List<Children> getChildrenList() {

        return  childrenList;
    }

    public void setParentList(Human father) {
        if(father.parent.equals(Parent.father)||father.parent.equals(Parent.mom)){
            parentList.add(father);
        }

    }

    public  List<Human> getParentList(){
        return parentList;
    }


    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }
    @Override
    public String toString() {
        return
                "name = " + name + " " +
                ", birthDay = " + birthDay +
                ", dayOfDeath = " + dayOfDeath +
                ", gender = " + gender ;
    }


}
