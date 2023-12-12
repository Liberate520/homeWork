package ru.gb.family_tree.human;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human> {
    private List<Human> family;
    private int index;

    public HumanIterator(List<Human> family){
        this.family = family;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < family.size();
    }

    @Override
    public Human next(){
        if(hasNext()){
            Human member = family.get(index);
            index++;
            return member;
        } else {
            return null;
        }
    }
}
