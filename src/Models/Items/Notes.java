package Models.Items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import Models.NoteItemPredicate;
import Models.Comparators.ComparatorNoteItemByAuthor;
import Models.Comparators.ComparatorNoteItemByDateOfChange;
import Models.Comparators.ComparatorNoteItemByDateOfCreation;
import Models.Comparators.ComparatorNoteItemByHeader;
import Models.Comparators.ComparatorNoteItemById;

public class Notes<T extends NoteItem> implements Iterable<T>, Serializable{
    private List<T> items;
    public Notes(){
        items = new ArrayList<>();
    }

    //#region work with list   
    public void add( T note){
        items.add(note);
    }

    public void remove(T note){
       if(contains(note)){ 
            items.remove(note);
       }
    }

    public boolean contains(T note){
        return items.contains(note);
    }

    public int size(){
        return items.size();
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    public List<T> getFilteredItems(NoteItemPredicate predicate){
        return items.stream().filter(predicate::isEqual).collect(Collectors.toList());
    }

    //#endregion

    //#region sorting    
    public void sortByHeader(){
        items.sort(new ComparatorNoteItemByHeader<>());
    }

    public void sortById(){
        items.sort(new ComparatorNoteItemById<>());
    }

    public void sortByAuthor(){
        items.sort(new ComparatorNoteItemByAuthor<>());
    }

    public void sortByDateOfCreation(){
        items.sort(new ComparatorNoteItemByDateOfCreation<>());
    }

    public void sortByDateOfChange(){
        items.sort(new ComparatorNoteItemByDateOfChange<>());
    }
    //#endregion

    public boolean clear() {
        items.clear();
        return false;
    }

}
