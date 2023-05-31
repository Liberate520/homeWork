package java_oop_homeWork.src.model.display.displayFields.person;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayObjects.DisplayPersonOnlyName;
import java_oop_homeWork.src.model.display.displayFields.Field;
import java_oop_homeWork.src.model.person.Person;

import java.util.TreeSet;

public class Children extends Field {
    public Children(String title, Person entity){
        this.title = title;
        TreeSet<Person> children = entity.getChildren();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (Person child: children) {
            sb.append(new DisplayPersonOnlyName(new DisplayInfo("    ",""," ","\n"), child).prepareForPrint());
        }
        this.display= sb.toString();
    }
}
