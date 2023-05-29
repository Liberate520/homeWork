package java_oop_homeWork.src.model.display.displayFields.person;

import java_oop_homeWork.src.model.display.displayFields.Field;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateDeath extends Field {
    public DateDeath(String title, Date entity){
        this.title = title;
        this.display = (entity == null)?"-":entity.toString();
    }
}
