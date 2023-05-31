package java_oop_homeWork.src.model.display.displayFields;

import java.util.HashMap;
import java.util.Map;

public abstract class Field<E> {
    protected String title;
    protected String display;
    public String getTitle(){
        return title;
    }
    public String getDisplay(){
        return display;
    }
}
