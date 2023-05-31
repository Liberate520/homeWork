package java_oop_homeWork.src.model.display.displayObjects;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.person.Person;
import java_oop_homeWork.src.model.display.displayFields.person.Id;
import java_oop_homeWork.src.model.display.displayFields.person.Name;
import java_oop_homeWork.src.model.display.displayFields.person.SurName;

public class DisplayPersonOnlyName extends DisplayObject {
    public DisplayPersonOnlyName(DisplayInfo displayInfo, Person person) {
        super(displayInfo);
        fields.add(new Id("", person.getID()));
        fields.add(new Name("", person.getName()));
        fields.add(new SurName("", person.getSurname()));
    }
}
