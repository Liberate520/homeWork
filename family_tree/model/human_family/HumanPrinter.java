package family_tree.model.human_family;

import java.util.ArrayList;
import java.util.List;

public class HumanPrinter<T extends HumanItem> {
    private List<T> children;
    private List<T> parents;
    private Object birthYear;
    private Object name;
    private Object gender;

    public HumanPrinter() {
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getHumansInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(name).append("\n");
        sb.append("Birth Year: ").append(birthYear).append("\n");
        sb.append("Gender: ").append(gender).append("\n");
        sb.append("Parents: ");

        if (parents.isEmpty()) {
            sb.append("Unknown");
        } else {
            for (T parent : parents) {
                sb.append(parent).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        sb.append("\n");
        sb.append("Children: ");
        if (children.isEmpty()) {
            sb.append("None");
        } else {
            for (T child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

}
