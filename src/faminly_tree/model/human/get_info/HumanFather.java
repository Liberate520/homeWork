package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public class HumanFather extends InfoElements{
    public HumanFather(Human human) {
        super(human);
        description = "отец: ";
    }
    @Override
    public String getValue() {
        if (human.getFather() != null) return human.getFather().getName();
        else return null;
    }
}
