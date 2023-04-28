package service;

import fileWork.FilehandlerOS;
import fileWork.FilehandlerTXT;
import fileWork.Writeable;
import group.Groupable;
import group.comparators.PersonComparatorById;
import group.comparators.PersonComparatorByName;
import person.Person;
import restorePerson.RestorePersonFromConsole;
import view.CollecterInfo;

public class Service {
    private Groupable<Person> group;
    private Writeable<Person> fileOS;
    private Writeable<Person> fileTXT;

    public Service(Groupable<Person> group) {
        this.group = group;
        fileOS = new FilehandlerOS<>();
        fileTXT = new FilehandlerTXT<>();
    }

    public void addRecord(CollecterInfo collecterInfo) {
        if (group.getPersonByName(collecterInfo.getName()) == null) {
            RestorePersonFromConsole rPerson = new RestorePersonFromConsole();
            Person person = rPerson.restorePersonFromConsole(group, collecterInfo);
            group.addPerson(person);
            System.out.printf("Запись '" + person.getName() + "' добавлена.");
        } else
            System.out.println("Такой человек уже внесен.");
    }

    public String getPersonList() {
        return group.getPersonList().toString();
    }

    public void findRecord(String name) {
        group.findPerson(name);
    }

    public String loadPersonListOS() {
        group = fileOS.LoadFromFile("FamilyTree.dat");
        return group.getPersonList().toString();
    }

    public String loadPersonListTXT() {
        group = fileTXT.LoadFromFile("FamilyTree.txt");
        return group.getPersonList().toString();
    }

    public String savePersonList() {
        fileOS.SaveToFile(group, "FamilyTree.dat");
        fileTXT.SaveToFile(group, "FamilyTree.txt");
        return group.getPersonList().toString();
    }

    public void sortRecordsByName() {
        group.getPersonList().sort(new PersonComparatorByName<>());
        System.out.println(group);
    }

    public void sortRecordsById() {
        group.getPersonList().sort(new PersonComparatorById<>());
        System.out.println(group);
    }
}
