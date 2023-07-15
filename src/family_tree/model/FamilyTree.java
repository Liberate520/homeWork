package family_tree.model;

import family_tree.model.group.GroupAgedNamed;
import family_tree.model.group.Group;
import family_tree.model.human.Human;
import family_tree.model.marriage.Marriage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private GroupAgedNamed<Human> listItems;
    private Group<Marriage<Human>> marriages;
    public FamilyTree(){
        listItems = new GroupAgedNamed<>();
        marriages = new Group<>();
    }
    public void addHuman(Human t){
        listItems.add(t);
    }
    public void addMarriage(Marriage m){
        marriages.add(m);
    }
    public Human getItemById(int id){
        for(Human t : listItems)
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
        return listItems.getInfo();
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

    public String getInfoLastHuman(){
        if (listItems.getSize() == 0) return "";
        Human lastHuman = listItems.getElementByIndex(listItems.getSize()-1);
        return lastHuman.getInfo();
    }
    public String getInfoLastMarriage(){
        if (marriages.getSize() == 0) return "";
        Marriage m = marriages.getElementByIndex(marriages.getSize()-1);
        return m.getInfo();
    }
    public void sortItemsByName(){
        listItems.sortByName();
    }
    public void sortItemsByAge(){
        listItems.sortByAge();
    }
    @Override
    public String toString() {
        return getInfoAll();
    }
}

/*public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable {
    private GroupAgedNamed<T> listItems;
    private Group<Marriage<T>> marriages;  
    public FamilyTree(){
        listItems = new GroupAgedNamed<>();
        marriages = new Group<>();
    }
    public void add(T t){
        listItems.add(t);
    }
    public void addMarriage(Marriage m){
        marriages.add(m);
    }
    public T getItemById(int id){
        for(T t : listItems)
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
        return listItems.getInfo();
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
    public void sortItemsByName(){
        listItems.sortByName();
    }
    public void sortItemsByAge(){
        listItems.sortByAge();
    }
    @Override
    public String toString() {
        return getInfoAll();
    }
}*/
