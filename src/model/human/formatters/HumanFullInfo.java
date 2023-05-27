package model.human.formatters;

import model.human.Gender;
import model.human.Human;

public class HumanFullInfo implements HumanFormat {

    private Human human;

    public HumanFullInfo(Human human) {
        this.human = human;
    }

    @Override
    public String showHumanInfo() {
        String genderString = human.getGender().equals(Gender.Male) ? "мужской" : "женский";
        if (human.getChildrens().size() > 0) {
            if (human.getFatherName() != null && human.getFatherName() != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d, мать - %s, отец - %s, дети - %s",
                        human.getSurName(),
                        human.getName(),
                        human.getFatherName(), genderString, human.getAge(),
                        human.getMother() == null ? "нет" : human.getMother().getShortInfo(),
                        human.getFather() == null ? "нет" : human.getFather().getShortInfo(),
                        human.getChildrenInfo());
            } else {
                return String.format("%s %s, пол - %s, возраст - %d, мать - %s, отец - %s, дети - %s",
                        human.getSurName(),
                        human.getName(),
                        genderString, human.getAge(),
                        human.getMother() == null ? "нет" : human.getMother().getShortInfo(),
                        human.getFather() == null ? "нет" : human.getFather().getShortInfo(),
                        human.getChildrenInfo());
            }
        } else {

            if (human.getFatherName() != null && human.getFatherName() != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d, мать - %s, отец - %s, детей нет",
                        human.getSurName(),
                        human.getName(),
                        human.getFatherName(),
                        genderString, human.getAge(),
                        human.getMother() == null ? "нет" : human.getMother().getShortInfo(),
                        human.getFather() == null ? "нет" : human.getFather().getShortInfo());
            } else {
                return String.format("%s %s, пол - %s, возраст - %d, мать - %s, отец - %s, детей нет",
                        human.getSurName(),
                        human.getName(),
                        genderString, human.getAge(),
                        human.getMother() == null ? "нет" : human.getMother().getShortInfo(),
                        human.getFather() == null ? "нет" : human.getFather().getShortInfo());
            }
        }
    }

}
