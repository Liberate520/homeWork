package java_oop_homeWork.src.model.display.displayFields.person;

import java_oop_homeWork.src.model.Sex;
import java_oop_homeWork.src.model.display.displayFields.Field;

import java.util.HashMap;
import java.util.Map;

public class Alive extends Field {
    static private Map<Boolean, String> map = Map.of(
        true, "жив",
        false, "мёртв"
    );

    public Alive(String title, Boolean entity){
        this.title = title;
        this.display = map.get(entity);
    }
}
