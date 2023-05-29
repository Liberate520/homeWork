package java_oop_homeWork.src.model.display.displayFields.familyTree;

import java_oop_homeWork.src.model.display.displayFields.Field;
import java_oop_homeWork.src.model.person.Person;

public class FamilyTreeName extends Field<String> {
    public FamilyTreeName(String title, String entity){
        this.title = title;
        display = entity;
    }
}
