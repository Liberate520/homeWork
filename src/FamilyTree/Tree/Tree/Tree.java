package FamilyTree.Tree.Tree;

import FamilyTree.Tree.FileHander.Writable;
import FamilyTree.Tree.HumanGroup.Human.Human;
import FamilyTree.Tree.HumanGroup.HumanGroupItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tree <E extends Human> implements Serializable {
    private   List<E> humanList;

    public Tree(List<E> humanList) {
        this.humanList = humanList;
    }
    public Tree(){
        this(new ArrayList<>());
    }
    public boolean add(E human){
        if (human == null){
            return false;
        }
        if ( !humanList.contains(human)){
            humanList.add(human);

            return true;
        }
        return false;
    }
    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for (E human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString(){
        return getHumansInfo();
    }
}
