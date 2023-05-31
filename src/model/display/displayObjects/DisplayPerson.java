package java_oop_homeWork.src.model.display.displayObjects;

import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayFields.person.*;
import java_oop_homeWork.src.model.person.Person;

public class DisplayPerson extends DisplayObject {
    public DisplayPerson(DisplayInfo displayInfo, Person person) {
        super(displayInfo);
        fields.add(new Id("", person.getID()));
        fields.add(new Name("", person.getName()));
        fields.add(new SurName("", person.getSurname()));
        fields.add(new DateBirth("Дата рождения", person.getDateBirth()));
        fields.add(new DateDeath("Дата смерти", person.getDateDeath()));
        fields.add(new Father("Отец", person.getFather()));
        fields.add(new Mother("Мать", person.getMother()));
        fields.add(new Children("Дети", person));
        fields.add(new SexField("Пол", person.getSex()));
        fields.add(new Alive("", person.getAlive()));
    }
}
