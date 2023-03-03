package org.example.model.add_remove_human;

import org.example.model.Gender;
import org.example.model.Human;
import org.example.model.Tree;

import java.time.LocalDate;

public class AddHuman {

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String id, Tree<Human> tree){
        tree.getBigFamily().add(new Human(name, gender, dateOfBirth, dateOfDeath, id, tree));
    }
}
