package java_oop_homeWork.src.model.display.displayFields.person;

import java_oop_homeWork.src.model.display.displayFields.Field;
import java_oop_homeWork.src.model.person.Person;

public class Father extends Field {
    public Father(String title, Person entity){
        this.title = title;
        this.display = (entity == null)?"-":entity.getID() + " " + entity.getName();
    }
}
