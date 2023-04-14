package model.service;

import java.time.LocalDate;
import java.util.Scanner;
import model.fileWork.FilehandlerOS;
import model.fileWork.FilehandlerTXT;
import model.fileWork.Writeable;
import model.group.Groupable;
import model.group.Comparators.PersonComparatorByName;
import model.person.Person;

public class Service {
    private Groupable<Person> group;
    private Writeable<Person> fileOS;
    private Writeable<Person> fileTXT;
    private Scanner scanner;

    public Service(Groupable<Person> group) {
        this.group = group;
        scanner = new Scanner(System.in, "cp866");
        fileOS = new FilehandlerOS<>();
        fileTXT = new FilehandlerTXT<>();
    }

    public void addRecord(String name) {
        if (group.getPersonByName(name) == null) {

            Person person = new Person(0, name, null, null, null, null, null, null);

            System.out.println("Введите дату рождения в формате год-месяц-день.");
            String[] dataBirth = scanner.nextLine().split("-");
            person.setBirthDate(LocalDate.of(Integer.parseInt(dataBirth[0]), Integer.parseInt(dataBirth[1]),
                    Integer.parseInt(dataBirth[2])));

            person.setId(group.getPersonList().get(group.getPersonList().size() - 1).getId() + 1);

            System.out.println("Введите имя и фамилию матери, если она не известна введите 'нет'.");
            String motherName = scanner.nextLine();
            if (motherName.equals("нет"))
                person.setMother(null);
            else
                person.setMother(group.getPersonByName(motherName));

            System.out.println("Введите имя и фамилию отца, если она не известна введите 'нет'.");
            String fatherName = scanner.nextLine();
            if (fatherName.equals("нет"))
                person.setFather(null);
            else
                person.setFather(group.getPersonByName(fatherName));
            group.addPerson(person);
            System.out.println(group.toString());
        } else
            System.out.println("Такой человек уже внесен.");
    }

    public String getPersonList() {
        return group.getPersonList().toString();
    }

    public Person findRecord(String name) {
        Person findPerson = group.getPersonByName(name);
        System.out.println(findPerson);
        return findPerson;
    }

    public String loadPersonList() {
        group = fileOS.LoadFromFile("FamilyTree.dat");
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
}