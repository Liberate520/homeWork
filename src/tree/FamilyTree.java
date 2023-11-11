package HomeWork.familyTree.homeWork22_10_23.src.tree;


import HomeWork.familyTree.homeWork22_10_23.src.human.*;
import HomeWork.familyTree.homeWork22_10_23.src.human.Comparator.HumanComparatorByAge;
import HomeWork.familyTree.homeWork22_10_23.src.human.Comparator.HumanComparatorByName;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class FamilyTree implements Serializable , Iterable<Human>{
//    private long idHuman;
    private List<Human> humanList ;


    public FamilyTree(){
        humanList = new ArrayList<>();

    }


//    public String getHumanListInfo(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Список людей : \n");
//        for(Human human:humanList){
//            stringBuilder.append(human.getId());
//            stringBuilder.append(" ");
//            stringBuilder.append(human.getSurname());
//            stringBuilder.append(human.getName());
//            stringBuilder.append(human.getPatronymic());
//            stringBuilder.append(human.getAge().getYear());
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }

    public void addHuman(Human human){
       if(!humanList.contains(human)) {
           humanList.add(human);
       }
    }
    public void sortBySurname(){
        humanList.sort(new HumanComparatorBySurname());
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }
}




