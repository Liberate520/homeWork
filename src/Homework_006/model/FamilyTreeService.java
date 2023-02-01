package Homework_006.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FamilyTreeService <T extends BaseType> {
    
    private FamilyTree familyTree;
       
    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
    }

    public List<T> read() throws ClassNotFoundException, IOException {
        Writer writer = new Writer();
        this.familyTree = writer.read();
        return this.familyTree.getAll();
    }

    public List<T> show() {
       return this.familyTree.getAll();
    }

    public FamilyTree sortById() {
        Collections.sort(this.familyTree.getAll(), new ComparatorById());
        return this.familyTree;
    }

    public FamilyTree sortByDate() {
        Collections.sort(this.familyTree.getAll(), new ComparatorByDate());
        return this.familyTree;
    }

    public void save() throws ClassNotFoundException, IOException {
        Writer writer = new Writer();
        writer.save(this.familyTree);
    }

    public void createNode(ArrayList<String> prop) {
        BaseType node = new BaseType (prop.get(0), prop.get(1), prop.get(2));
        this.familyTree.add(node);
    }


    public void sortByName(){
        Collections.sort(familyTree.getAll());
    }
    
    public void svSetParent(int[] ids){
        BaseType child = familyTree.getHumanById(ids[0]);
        BaseType parent = familyTree.getHumanById(ids[1]);
        child.setParent(parent);
    }

    public boolean checkId(int checked_id){
        ArrayList<Integer> ft_ids = familyTree.getAllid();
        for (int id : ft_ids){
            if (id==checked_id) return true;
        }
       
        return false;
    }


    public List<T> showParents(int id){
        Research research = new Research<>(this.familyTree); 
        return research.getParentsById(id);
    }

    public List<T> showBrothersAndSisters(int id){
        Research research = new Research<>(this.familyTree);
        return research.getBrothersAndSistersById(id);
    }

}
