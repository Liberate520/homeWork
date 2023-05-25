package model.human.formatters;

import model.human.Human;

public class HumanChildrenInfo implements HumanFormat {
    Human human;
    
    public HumanChildrenInfo(Human human) {
        this.human = human;
    }

    @Override
    public String showHumanInfo() {
        int count = human.getChildrens().size();
        if (count > 0) {
            String result="";
            for (int i = 0; i < count - 1; i++) {
                result += human.getChildrens().get(i).getFullName() + ", ";
            }
            result += human.getChildrens().get(count - 1).getFullName();
            return result;
        }
        return "детей нет";
    }
    
}
