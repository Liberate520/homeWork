package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public class HumanName extends InfoElements{
    public HumanName(Human human) {
        super(human);
        description = "имя: ";
    }
    @Override
    public String getValue() {
        if (human.getName() == null) return null;
        else return human.getName();
    }
}
