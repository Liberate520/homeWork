package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public class HumanSurname extends InfoElements {
    public HumanSurname(Human human) {
        super(human);
        description = "фамилия: ";
    }
    @Override
    public String getValue() {
        if(human.getSurname() == null) return null;
        else return human.getSurname();
    }
}
