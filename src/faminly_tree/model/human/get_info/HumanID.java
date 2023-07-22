package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public class HumanID extends InfoElements {
    public HumanID(Human human) {
        super(human);
        description = "id: ";
    }
    @Override
    public String getValue() {
        return Integer.toString(human.getId());
    }

}
