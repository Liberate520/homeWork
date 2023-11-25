package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class Children {
    public List<Human> children;

    public Children() {
        this.children = new ArrayList<>();
    }

    public void addMember(Human human) {
        children.add(human);
    }

    public List<Human> getMembers() {
        return children;
    }
}
