package homeWork.FamalyTree.model.FamalysTree;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWork.FamalyTree.model.Human.HumanComporatoByAge;
import homeWork.FamalyTree.model.Human.HumanIterator;
import homeWork.FamalyTree.model.Service.SaveLoad.FileHandler;

public class FamalyTree<E extends ItemTree<E>> implements Serializable, Iterable<E>  {
    private long humanId;
    private List<E> humanList;


    public FamalyTree(List<E> humanList){
        this.humanList = humanList;
    }

    public FamalyTree(){
        this(new ArrayList<>());
    }

    public boolean addHumman(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            addToChildren(human);
            addToParent(human);
            return true;
        }
        return false;
        
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParents(human);
        }
    }

    private void addToParent(E human){
        for (E child: human.getParents()){
            child.addChild(human);
        }
    }


    public String getHumanInfo(){
        StringBuilder sb = new StringBuilder();
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getHumanInfo();
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public void SaveData(FamalyTree<E> list, File file){
        FileHandler<E> fileHandler = new FileHandler<E>();
        fileHandler.Save(list, file);
    }

    public void LoadDate(FamalyTree<E> list, File file){
        FileHandler<E> fileHandler = new FileHandler<E>();        
        fileHandler.LoadDate(list, file);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }
    
    public void sortByName(){
        humanList.sort(new HumanComporatoByAge<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComporatoByAge<>());
    }
}