package HomeWork.familyTree.homeWork22_10_23.src;

import HomeWork.familyTree.homeWork22_10_23.src.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int curId;

    public Human build(String surname, String name, String patronymic, LocalDate birthDay, Gender gender){
        return new Human(curId++, surname, name, patronymic, birthDay, gender);

    }
}
