package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

public abstract class InfoElements {
    String description;
    Human human;

    public InfoElements(Human human) {
        this.human = human;
    }
    public String getDescription() {
        return description;
    }
    public abstract String getValue();
}
