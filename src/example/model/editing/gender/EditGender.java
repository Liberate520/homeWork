package org.example.model.editing.gender;

import org.example.model.Gender;
import org.example.model.Human;
import org.example.model.Tree;

public class EditGender {


    public void editGender(String gender, Integer index, Tree<Human> tree){
        if (gender.equals("1")){
            tree.getBigFamily().get(index).setGender(Gender.male);
        } else {
            tree.getBigFamily().get(index).setGender(Gender.female);
        }
    }
}
