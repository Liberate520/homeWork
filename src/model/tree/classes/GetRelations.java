package model.tree.classes;

import java.util.List;

public class GetRelations {

    public String getDescendants(Human human) {
        List<Human> children = human.getChildren();
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\nDescendants:\n");
        if (children.size() > 0) {
            for (Human hum : children) {
                sb.append(hum.toString() + "\n");
            }
        } else
            sb.append("Unknown!\n");
        return sb.toString();
    }

    public String getParents(Human human) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\nParents:");
        sb.append("\nFather:");
        if (human.getFather() != null)
            sb.append("\n" + human.getFather().toString());
        else
            sb.append("\nUnknown!");

        sb.append("\nMother:");
        if (human.getMother() != null)
            sb.append("\n" + human.getMother().toString());
        else
            sb.append("\nUnknown!\n");
        return sb.toString();
    }   
}
