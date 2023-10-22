package HomeWork.familyTree.homeWork22_10_23.src.human;

import HomeWork.familyTree.homeWork22_10_23.src.Baby;
import HomeWork.familyTree.homeWork22_10_23.src.Gender;

import java.time.LocalDate;

public class Children extends Human {
    private Baby baby;



    public Children(String name, LocalDate birthDay, LocalDate dayOfDeath, Gender gender, Baby baby) {
        super(name, birthDay, dayOfDeath, gender);
        this.baby = baby;

    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }




    @Override
    public String toString() {
        return super.toString() +
                " baby= " + baby;
    }

}
