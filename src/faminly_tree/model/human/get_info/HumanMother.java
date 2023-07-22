package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public class HumanMother extends InfoElements{
    public HumanMother(Human human) {
        super(human);
        description = "мать: ";
    }
    @Override
    public String getValue() {
        if (human.getMother() != null) return human.getMother().getName();
        else return null;
    }
}
