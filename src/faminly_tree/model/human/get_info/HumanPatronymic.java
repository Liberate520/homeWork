package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public class HumanPatronymic extends InfoElements{
    public HumanPatronymic(Human human) {
        super(human);
        description = "отчество: ";
    }
    @Override
    public String getValue() {
        if (human.getPatronymic() == null) return null;
        else return human.getPatronymic();
    }
}
