package java_oop_homeWork.src.model.display.displayFields.person;

import java_oop_homeWork.src.model.display.displayFields.Field;

public class Id extends Field {
    public Id(String title, int entity){
        this.title = title;
        this.display = String.valueOf(entity);
    }
}
