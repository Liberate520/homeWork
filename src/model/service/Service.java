package service;

import java.util.List;

import fileWork.FilehandlerOS;
import fileWork.FilehandlerTXT;
import fileWork.Filename;
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
    private Filename filenameOS;
    private Filename filenameTXT;
  

    public Service(Groupable<Person> group) {
        this.group = group;
        fileOS = new FilehandlerOS<>();
        fileTXT = new FilehandlerTXT<>();
        filenameOS = new Filename("FamilyTree.dat");
        filenameTXT = new Filename("FamilyTree.txt");
    }
        
    public String getFileNameOS() {
        return filenameOS.getName();
    }

    public String getFileNameTXT() {
        return filenameTXT.getName();
    }

    public boolean addRecord(CollecterInfo collecterInfo) {
        boolean find=false;
        if (group.getPersonByName(collecterInfo.getName()) == null) {
            RestorePersonFromConsole rPerson = new RestorePersonFromConsole();
            Person person = rPerson.restorePersonFromConsole(group, collecterInfo);
            find=true;
            group.addPerson(person);
            return find;
        } else
            return find;
    }

    public String getPersonList() {
        return group.getPersonList().toString();
    }

    public List<String> findRecord(String name) {
        return group.findPerson(name);
    }

    public String loadPersonListOS() {
        group = fileOS.LoadFromFile(filenameOS.getName());
        return group.getPersonList().toString();
    }

    public String loadPersonListTXT() {
        group = fileTXT.LoadFromFile(filenameTXT.getName());
        return group.getPersonList().toString();
    }

    public String savePersonList() {
        fileOS.SaveToFile(group, filenameOS.getName());
        fileTXT.SaveToFile(group, filenameTXT.getName());
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
