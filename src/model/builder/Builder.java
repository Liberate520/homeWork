


//В общем, пока я только всё сломала. Не выходит пока заставить билдер работать.

/*
package model.builder;

import model.familyTree.FamilyTreeItem;
import model.human.gender.Gender;
import model.human.Human;

import java.time.LocalDate;

public class Builder {
    private int maxId;

    public Human build(String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father){
        Human model.human = new Human(maxId++, name, gender, birthDay, deathDay, mother, father);
        return model.human;
    }
    public Human build(String name, Gender gender, LocalDate birthDay, Human mother, Human father){
        Human model.human = new Human(maxId++, name, gender, birthDay, mother, father);
        return model.human;
    }public Human build(String name, Gender gender, LocalDate birthDay){
        Human model.human = new Human(maxId++, name, gender, birthDay);
        return model.human;
    }
    public Human build(String name, Gender gender){
        Human model.human = new Human(maxId++, name, gender);
        return model.human;
    }

    public Human build(String name, Gender gender, LocalDate birthDay,Human mother){
        Human model.human = new Human(maxId++, name, gender, birthDay, mother);
        return model.human;
    }
}
*/