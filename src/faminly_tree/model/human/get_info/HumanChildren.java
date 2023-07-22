package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

import java.util.List;

public class HumanChildren extends InfoElements{
    public HumanChildren(Human human) {
        super(human);
        description = "дети: ";
    }

    @Override
    public String getValue() {
        StringBuilder sb = new StringBuilder();
        List<Human> children = human.getChildren();
        if (children == null) return null;
        else {
            for(Human el : children){
                sb.append(el.getName());
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}
