package family_tree.model.marriage;

import family_tree.model.Reportable;
import family_tree.model.group.ItemFamilyTree;

import java.io.Serializable;

public class ReportableMarriage<T extends ItemFamilyTree<T>> implements Reportable<Marriage<T>>, Serializable {
    @Override
    public String getInfo(Marriage<T> m) {
        return "{id: " + m.id
                + ", Супруга: {" + m.wife.getName() + ", id=" + m.wife.getId() + '}'
                + ", Супруг: {" + m.husband.getName() + ", id=" + m.husband.getId() + '}'
                + ", заключен: " + m.startDate.toString()
                + (m.endDate == null ? ", статус: действителен" : ", статус: расторгнут " + m.endDate.toString())
                + "}";
    }
}
