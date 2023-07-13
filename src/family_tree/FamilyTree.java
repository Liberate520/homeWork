package family_tree;

import family_tree.group.GroupAgedNamed;
import family_tree.group.Group;
import family_tree.marriage.Marriage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends ItemAgedNamedId> implements Serializable {
    private GroupAgedNamed<T> listItems;
    private Group<Marriage> marriages;    //only for Human!
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
    public String getHumansInfo(){
        return listItems.getInfo();
    }
    public String getMarriagesInfo(){
        List<String> strings = new ArrayList<>();
        for (Marriage m : marriages)
            strings.add(m.getInfo());
        return String.join("\n", strings);
    }
    public String getInfoAll(){
        return "{ humans: \n"
                + getHumansInfo()
                + ",\nmarriages: \n"
                + getMarriagesInfo()
                + "\n}";
    }
    public void sortHumansByName(){
        listItems.sortByName();
    }
    public void sortHumansByAge(){
        listItems.sortByAge();
    }
    @Override
    public String toString() {
        return getInfoAll();
    }
}
