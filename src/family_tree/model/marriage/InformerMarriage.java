package family_tree.model.marriage;

import family_tree.model.Informer;
import family_tree.model.group.ItemFamilyTree;

import java.io.Serializable;

public class InformerMarriage<T extends ItemFamilyTree<T>> implements Informer<Marriage<T>>, Serializable {
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
