package java_oop_homeWork.src.model.display.displayFields.person;
import java_oop_homeWork.src.model.Sex;
import java_oop_homeWork.src.model.display.displayFields.Field;

import java.util.HashMap;
import java.util.Map;

public class SexField extends Field {
    private static Map<Sex, String> map = Map.of(
        Sex.men, "Мужской",
        Sex.women, "Женский"
    );

    public SexField(String title, Sex entity){
        this.title = title;
        this.display = map.get(entity);
    }

}
