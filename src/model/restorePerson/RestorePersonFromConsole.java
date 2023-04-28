package restorePerson;

import java.time.LocalDate;

import group.Groupable;
import person.Person;
import view.CollecterInfo;

/**
 * Класс восстанавливает человека по данным, пришедшим из консоли.
 */
public class RestorePersonFromConsole {

    public Person restorePersonFromConsole(Groupable<Person> group, CollecterInfo collecterInfo) {
        Person person = new Person(0, collecterInfo.getName(), null,
                null, null, null, null, null);
        if (group.getPersonList() == null)
            person.setId(1);
        else {
            int maxId = 1;
            for (int i = 0; i < group.getPersonList().size(); i++) {
                if (group.getPersonList().get(i).getId() > maxId)
                    maxId = group.getPersonList().get(i).getId();
            }
            person.setId(maxId + 1);
        }

        String[] dataBirth = collecterInfo.getBirthDate().split("-");
        person.setBirthDate((LocalDate.of(Integer.parseInt(dataBirth[0]), Integer.parseInt(dataBirth[1]),
                Integer.parseInt(dataBirth[2]))));

        if (collecterInfo.getDeathDate().equals("нет"))
            person.setDeathDate(null);
        else {
            String[] dataOfDeath = collecterInfo.getDeathDate().split("-");
            person.setDeathDate(LocalDate.of(Integer.parseInt(dataOfDeath[0]), Integer.parseInt(dataOfDeath[1]),
                    Integer.parseInt(dataOfDeath[2])));
        }

        if (collecterInfo.getMotherName().equals("нет"))
            person.setMother(null);
        else
            person.setMother(group.getPersonByName(collecterInfo.getMotherName()));

        if (collecterInfo.getFatherName().equals("нет"))
            person.setFather(null);
        else
            person.setFather(group.getPersonByName(collecterInfo.getFatherName()));
        return person;
    }
}