package src;

import java.util.List;

public class ShowTree<T extends It> {
    public String displayTree(T root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            displayTreeHelper(root, 0, sb);
        } else {
            sb.append("ID отсутствует");
        }
        return sb.toString();
    }

    private void displayTreeHelper(T person, int level, StringBuilder sb) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("└───   ");
        }
        sb.append(indent).append(person.getShortName()).append(" (").append(person.getDateOfBorn()).append(" - ").append(person.getDateOfDeath()).append(")\n");

        List<T> children = (List<T>) person.getChildren();
        for (T child : children) {
            displayTreeHelper(child, level + 1, sb);
        }
    }

}
