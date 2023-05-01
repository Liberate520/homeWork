package model.restoreHuman;

import java.time.LocalDate;

import model.group.Groupable;
import model.human.Human;
import view.CollecterInfo;

public class RestoreHumanFromConsole {
    public Human restoreHumanFromConsole(Groupable<Human> group, CollecterInfo collecterInfo) {
        Human human = new Human(0, collecterInfo.getName(), null,
                null, null, null, null, null);
        if (group.getHumanList() == null)
            human.setId(1);
        else {
            int maxId = 0;
            for (int i = 0; i < group.getHumanList().size(); i++) {
                if (group.getHumanList().get(i).getId() > maxId)
                    maxId = group.getHumanList().get(i).getId();
            }
            human.setId(maxId + 1);
        }

        String[] dataBirth = collecterInfo.getBirthDate().split("-");
        human.setBirthDate((LocalDate.of(Integer.parseInt(dataBirth[0]), Integer.parseInt(dataBirth[1]),
                Integer.parseInt(dataBirth[2]))));

        if (collecterInfo.getDeathDate().equals("нет"))
            human.setDeathDate(null);
        else {
            String[] dataOfDeath = collecterInfo.getDeathDate().split("-");
            human.setDeathDate(LocalDate.of(Integer.parseInt(dataOfDeath[0]), Integer.parseInt(dataOfDeath[1]),
                    Integer.parseInt(dataOfDeath[2])));
        }

        if (collecterInfo.getMotherName().equals("нет"))
            human.setMother(null);
        else
            human.setMother(group.getHumanByName(collecterInfo.getMotherName()));

        if (collecterInfo.getFatherName().equals("нет"))
            human.setFather(null);
        else
            human.setFather(group.getHumanByName(collecterInfo.getFatherName()));
        return human;
    }
}