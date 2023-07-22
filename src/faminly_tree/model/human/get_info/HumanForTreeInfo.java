package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;
import faminly_tree.model.tree.FamilyItem;
import java.util.ArrayList;
import java.util.List;

public class HumanForTreeInfo<E extends FamilyItem<E>> {
    Human human;
    private List<InfoElements> info;
    public HumanForTreeInfo(E human) {
        this.human = (Human) human;
        info = new ArrayList<>();
        info.add(new HumanID(this.human));
        info.add(new HumanName(this.human));
        info.add(new HumanSurname(this.human));
        info.add(new HumanPatronymic(this.human));
        info.add(new HumanAge(this.human));
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i).getValue() != null) {
                sb.append(info.get(i).getDescription());
                sb.append(info.get(i).getValue());
                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
