package model.human.formatters;

import model.human.Gender;
import model.human.Human;

public class HumanShortInfo implements HumanFormat {
    Human human;

    public HumanShortInfo(Human human) {
        this.human = human;
    }

    @Override
    public String showHumanInfo() {
        String genderString = human.getGender().equals(Gender.Male) ? "мужской" : "женский";
        if (human.getChildrens().size() > 0) {
            if (human.getFatherName() != null && human.getFatherName() != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d", human.getSurName(), human.getName(),
                        human.getFatherName(),
                        genderString, human.getAge());
            } else {
                return String.format("%s %s, пол - %s, возраст - %d", human.getSurName(), human.getName(), genderString,
                        human.getAge());
            }
        } else {

            if (human.getFatherName() != null && human.getFatherName() != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d", human.getSurName(), human.getName(),
                        human.getFatherName(),
                        genderString, human.getAge());
            } else {
                return String.format("%s %s, пол - %s, возраст - %d", human.getSurName(), human.getName(), genderString,
                        human.getAge());
            }
        }
    }

}
