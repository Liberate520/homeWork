package family_tree.model;

import family_tree.model.group.GroupExtended;
import family_tree.model.group.Group;
import family_tree.model.marriage.Marriage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable {
    private GroupExtended<T> items;
    private Group<Marriage<T>> marriages;
    public FamilyTree(){
        items = new GroupExtended<>();
        marriages = new Group<>();
    }
    public void addItem(T t){
        items.add(t);
    }
    public void addMarriage(Marriage m){
        marriages.add(m);
    }
    public T getItemById(int id){
        for(T t : items)
            if(t.getId() == id)
                return t;
        return null;
    }
    public Marriage getMarriageById(int id){
        for(Marriage m : marriages)
            if(m.getId() == id)
                return m;
        return null;
    }
    public String getItemsInfo(){
        return items.getInfo();
    }
    public String getMarriagesInfo(){
        List<String> strings = new ArrayList<>();
        for (Marriage m : marriages)
            strings.add(m.getInfo());
        return String.join("\n", strings);
    }
    public String getInfoAll(){
        return "{ items: \n"
                + getItemsInfo()
                + ",\nmarriages: \n"
                + getMarriagesInfo()
                + "\n}";
    }

    public String getInfoLastItem(){
        if(items.getSize() == 0) return "";
        return items.getElementByIndex(items.getSize()-1).getInfo();
    }

    public String getInfoLastMarriage(){
        if(marriages.getSize() == 0) return "";
        return marriages.getElementByIndex(marriages.getSize()-1).getInfo();
    }

    public void sortItemsByName(){
        items.sortByName();
    }
    public void sortItemsByAge(){
        items.sortByAge();
    }
    @Override
    public String toString() {
        return getInfoAll();
    }
}
