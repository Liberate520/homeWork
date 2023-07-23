package family_tree.model;

import family_tree.model.group.*;
import family_tree.model.marriage.Marriage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable {
    private CollectableItemFamilyTree<T> items;
    private Collectable<Marriage<T>> marriages;
    private Reportable<FamilyTree> reportable;
    public FamilyTree(CollectableItemFamilyTree<T> items, Collectable<Marriage<T>> marriages, Reportable<FamilyTree> reportable){
        this.items = items;
        this.marriages = marriages;
        this.reportable = reportable;
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
        return marriages.getInfo();
    }
    public String getInfoAll(){
        return reportable.getInfo(this);
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
