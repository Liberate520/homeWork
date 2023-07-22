package faminly_tree.model.human.get_info;

import faminly_tree.model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanInfo {
    private List<InfoElements> info;
    public HumanInfo(Human human) {
        info = new ArrayList<>();
        info.add(new HumanID(human));
        info.add(new HumanName(human));
        info.add(new HumanSurname(human));
        info.add(new HumanPatronymic(human));
        info.add(new HumanAge(human));
        info.add(new HumanFather(human));
        info.add(new HumanMother(human));
        info.add(new HumanChildren(human));
        //info.add(new HumanGender(human));
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
