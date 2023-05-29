package java_oop_homeWork.src.model.display.displayFields.familyTree;

import java_oop_homeWork.src.model.display.displayFields.Field;
import java_oop_homeWork.src.model.person.Person;

public class FamilyTreeCountKins extends Field<Integer> {
    public FamilyTreeCountKins(String title, Integer entity){
        this.title = title;
        display = entity + " членов семьи";
    }
}
