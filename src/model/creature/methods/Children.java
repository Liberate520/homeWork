package model.creature.methods;

import model.creature.Creature;
import model.creature.Interface.AddChildren;

import java.util.ArrayList;
import java.util.List;

public class Children implements AddChildren<Creature> {
    private List<Creature> children;

    public Children(List<Creature> children) {
        children = new ArrayList<>();
    }

      @Override
    public boolean addChildren(Creature child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("unknown");
        }
        return res.toString();
    }

    public List<Creature> getChildren() {
        return children;
    }

    public void setChildren(List<Creature> children) {
        this.children = children;
    }


}

