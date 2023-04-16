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
import human.IRelations;

public class Tree<T extends IRelations> implements Serializable, Iterable<Human<T>> {
    
    public HashMap<String, List<? extends T>> relations;
    private List<T> relationList;

    public Tree(T human) {
        relations = allRelations(human);
        relationList = TreeList();
    }

    private HashMap<String, List<? extends T>> allRelations(T human) {
        HashMap<String, List<? extends T>> allRelations = new HashMap<>();
        allRelations.put("я", human.me());
        allRelations.put("бабушки", human.grandMothers());
        allRelations.put("дедушки", human.grandFathers());
        allRelations.put("родители", human.parents());
        allRelations.put("братья и сестры", human.brotherAndSisters());
        allRelations.put("дети", human.childs());
        allRelations.put("внуки", human.grandChildrens());
        allRelations.put("супруг", human.spouse());
        return allRelations;

    }


    private List<T> TreeList() {
        Collection<? extends List<? extends T>> humanList = relations.values();
        List<T> hList = new ArrayList<>();
        for (List<? extends T> humansList : humanList) {
            if (humansList != null) {
                hList.addAll(humansList);
            }
        }
        return hList;
    }

    public List<T> getTreeList() {
        return this.relationList;
    }

    public List<T> getName(String name) {
        return getInfo(human -> human.getName().equals(name));
    }

    public List<T> getSurname(String surname) {
        return getInfo(human -> human.getSurname().equals(surname));
    }

    private List<T> getInfo(Predicate<T> byParam) {
        List<T> human = new ArrayList<>();
        relations.forEach((key, value) -> {
            human.addAll(value.stream().filter(byParam)
                    .collect(Collectors.toList()));
        });
        return human;
    }

    @Override
    public Iterator<Human<T>> iterator() {
        return new ExtendsHumanIterator(this);
    }

}