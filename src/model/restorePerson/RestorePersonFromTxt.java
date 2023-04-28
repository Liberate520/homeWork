package restorePerson;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import group.FamilyTree;
import group.Groupable;
import person.Gender;
import person.NodeTree;
import person.Person;

/**
 * Восстанавливает дерево из файла.txt
 */
public class RestorePersonFromTxt<T extends NodeTree<T>> {

    Groupable<Person> groupList = new FamilyTree<>();

    public Groupable<T> restorePersonFromTxt(String personInfo) {

        Person rPerson = new Person(0, null, null,
                null, null, null, null, null);

        Map<String, String> map = new HashMap<String, String>();
        String[] infoList = personInfo.split(", ");

        rPerson.setId(Integer.parseInt(infoList[0]));

        for (int i = 1; i < infoList.length; i++) {
            String[] element = infoList[i].split(": ");
            map.put(element[0], element[1]);
        }

        // for (var element : map.entrySet()) {
        // System.out.println(element);
        // }

        rPerson.setName(map.get("имя"));
        String[] bDate = map.get("дата рождения").split(
                "-");

        rPerson.setBirthDate(
                LocalDate.of(Integer.parseInt(bDate[0]), Integer.parseInt(bDate[1]), Integer.parseInt(bDate[2])));

        if (!personInfo.contains("дата смерти"))
            rPerson.setDeathDate(null);
        else {
            String[] dDate = map.get("дата смерти").split("-");
            rPerson.setDeathDate(
                    LocalDate.of(Integer.parseInt(dDate[0]), Integer.parseInt(dDate[1]),
                            Integer.parseInt(dDate[2])));
        }

        if (map.get("пол").equals("male"))
            rPerson.setGender(Gender.male);
        if (map.get("пол").equals("female"))
            rPerson.setGender(Gender.female);

        if (map.get("мать").equals("не определена") | groupList == null)
            rPerson.setMother(null);
        else
            rPerson.setMother(groupList.getPersonByName(map.get("мать")));

        if (map.get("отец").equals("не определен"))
            rPerson.setFather(null);
        else
            rPerson.setFather(groupList.getPersonByName(map.get("отец")));

        groupList.addPerson(rPerson);

        return (Groupable<T>) groupList;
    }
}