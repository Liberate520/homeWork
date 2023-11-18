package family_tree.family_tree;

import family_tree.base.Iterable;
import family_tree.human.Human;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTree implements Iterable {
    private String lastName;
    private String firstName;
    private double Id;
    private final List<Human> humanList;
    private double income;
    private double id;


    public FamilyTree(double id) {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        human.setId(Id++);
        humanList.add(human);
    }

//    public String getRelativeInfo(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Список :\n");
//        for (Human human: humanList){
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//
//    }

    public void sortByLastName(){
        FamilyTree familyTree = null;
        familyTree.sortByLastName();

    }

    @Override
    public String getLastName() {
        return lastName;
    }


    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setId(double id) {
        this.id = id;
    }

    @Override
    public double setId() {
        return 0;
    }



    @Override
    public double getIncome() {
        return income;
    }





}