package familyTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import human.Human;
import human.HumanIterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    public static transient List<Human> humans = new ArrayList<>();
    public HashMap<String, List<Human>> relations;
    private List<Human> relationList;

    public FamilyTree(Human human) {
        relations = human.allRelations();
        relationList = familyTreeList();
    }

    private List<Human> familyTreeList() {

        Collection<List<Human>> humanList = relations.values();
        List<Human> hList = new ArrayList<>();
        for (List<Human> humans : humanList) {
            if (humans != null) {
                hList.addAll(humans);
            }
        }
        return hList;

    }

    public List<Human> getFamilyTreeList() {
        return this.relationList;
    }

    public List<Human> getName(String name) {
        return getInfo(human -> human.name.equals(name));
    }

    public List<Human> getSurname(String surname) {
        return getInfo(human -> human.surname.equals(surname));
    }

    private List<Human> getInfo(Predicate<Human> byParam) {
        List<Human> human = new ArrayList<>();
        relations.forEach((key, value) -> {
            human.addAll(value.stream().filter(byParam)
                    .collect(Collectors.toList()));
        });
        return human;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(this);
    }

}