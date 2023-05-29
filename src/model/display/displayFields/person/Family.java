package java_oop_homeWork.src.model.display.displayFields.person;

import java_oop_homeWork.src.model.FamilyTree;
import java_oop_homeWork.src.model.display.displayFields.Field;

public class Family extends Field {
    public Family(String title, FamilyTree entity){
        this.title = title;
        display = entity.getName();
    }
}
