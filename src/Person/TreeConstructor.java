package Person;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import Group.Groupable;

public class TreeConstructor extends Person {

    Groupable<Person> groupList;

    public Person restorePersonByInfo(String personInfo) {

        Person restorePerson = new Person();
        personInfo.replaceAll(",", "");

        restorePerson.setId(personInfo.charAt(0));
        // String personInfo = "4, имя: Иванова Александра, дата рождения: 1982-03-22,
        // возраст: 41, пол: female, мать: Иванова Анастасия, отец: Иванов Петр, дети:
        // Петров Игорь Петрова Людмила,";
        Map<String, String> map = new HashMap<String, String>();
        String[] infoList = personInfo.split(", ");
        for (int i = 1; i < infoList.length - 1; i++) {
            String[] element = infoList[i].split(": ");
            map.put(element[0], element[1]);
        }

        for (var element : map.entrySet()) {
            System.out.println(element);
        }

        restorePerson.setName(map.get("имя"));

        String[] bDate = map.get("дата рождения").split("-");
        restorePerson.setBirthDate(
                LocalDate.of(Integer.parseInt(bDate[0]), Integer.parseInt(bDate[1]), Integer.parseInt(bDate[2])));

        if (!personInfo.contains("дата смерти"))
            restorePerson.setDeathDate(null);
        else {
            String[] dDate = map.get("дата смерти").split("-");
            ;
            restorePerson.setDeathDate(
                    LocalDate.of(Integer.parseInt(dDate[0]), Integer.parseInt(dDate[1]), Integer.parseInt(dDate[2])));
        }

        if (map.get("пол").equals("male"))
            restorePerson.setGender(Gender.male);
        if (map.get("пол").equals("female"))
            restorePerson.setGender(Gender.female);

        if (map.get("мать").equals("не определена"))
            restorePerson.setMother(null);
        else
            restorePerson.setMother(getPersonByName(map.get("мать")));

        if (map.get("отец").equals("не определен"))
            restorePerson.setFather(getPersonByName(map.get("отец")));
        else
            restorePerson.setFather(getPersonByName(map.get("отец")));

        if (personInfo.contains("детей нет"))
            restorePerson.setChildrens(null);
        else {
            String[] children = map.get("дети").split(" ");
            for (int i = 0; i < children.length; i = i + 2) {
                String child = children[i] + " " + children[i + 1];
                restorePerson.addChild(getPersonByName(child));
            }
        }
        return restorePerson;
    }

    public void addPerson(Person person) {
        groupList.addPerson(person);
        if (person.getMother() != null)
            person.getMother().addChild(person);

        if (person.getFather() != null)
            person.getFather().addChild(person);
    }

    public Person getPersonByName(String name) {
        Person findPerson = null;
        for (int i = 0; i < groupList.getPersonList().size(); i++) {
            if (groupList.getPersonList().get(i).getName().equals(name)) {
                findPerson = groupList.getPersonList().get(i);
            }
        }
        if (findPerson == null)
            System.out.println("Такой человек не найден.");
        return findPerson;
    }

    public Groupable<Person> getPersonList() {
        return groupList;
    }

}
