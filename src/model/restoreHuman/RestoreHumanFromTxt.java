package model.restoreHuman;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import model.group.FamilyTree;
import model.group.Groupable;
import model.human.Gender;
import model.human.NodeTree;
import model.human.Human;

public class RestoreHumanFromTxt<T extends NodeTree<T>> {

    Groupable<Human> groupList = new FamilyTree<>();

    public Groupable<T> restoreHumanFromTxt(String humanInfo) {

        Human human = new Human(0, null, null,
                null, null, null, null, null);

        Map<String, String> map = new HashMap<String, String>();
        String[] infoList = humanInfo.split(", ");

        human.setId(Integer.parseInt(infoList[0]));

        for (int i = 1; i < infoList.length; i++) {
            String[] element = infoList[i].split(": ");
            map.put(element[0], element[1]);
        }

        human.setName(map.get("имя"));
        String[] bDate = map.get("дата рождения").split(
                "-");

        human.setBirthDate(
                LocalDate.of(Integer.parseInt(bDate[0]), Integer.parseInt(bDate[1]), Integer.parseInt(bDate[2])));

        if (!humanInfo.contains("дата смерти"))
            human.setDeathDate(null);
        else {
            String[] dDate = map.get("дата смерти").split("-");
            human.setDeathDate(
                    LocalDate.of(Integer.parseInt(dDate[0]), Integer.parseInt(dDate[1]),
                            Integer.parseInt(dDate[2])));
        }

        if (map.get("пол").equals("male"))
            human.setGender(Gender.male);
        if (map.get("пол").equals("female"))
            human.setGender(Gender.female);

        if (map.get("мать").equals("не определена") | groupList == null)
            human.setMother(null);
        else
            human.setMother(groupList.getHumanByName(map.get("мать")));

        if (map.get("отец").equals("не определен"))
            human.setFather(null);
        else
            human.setFather(groupList.getHumanByName(map.get("отец")));

        groupList.addHuman(human);

        return (Groupable<T>) groupList;
    }
}
