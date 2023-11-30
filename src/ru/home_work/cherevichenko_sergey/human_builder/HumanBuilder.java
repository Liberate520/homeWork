package ru.home_work.cherevichenko_sergey.human_builder;
import ru.home_work.cherevichenko_sergey.human.Gender;
import ru.home_work.cherevichenko_sergey.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// Класс для создания человека
public class HumanBuilder implements Serializable {
    public Human build(String name, String lastName, Gender gender,
                         LocalDate birthDay, LocalDate dateDeath,List<Human> children){
        Human human = new Human(name,lastName,gender,birthDay,dateDeath,new ArrayList<>());
        return human;
    }
}
