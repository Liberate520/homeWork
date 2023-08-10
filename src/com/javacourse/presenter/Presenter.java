package com.javacourse.presenter;
import com.javacourse.view.View;


import com.javacourse.Family_tree.*;

public class Presenter {
    private View view;
    private FamilyList<Person> tree;

    public Presenter(View view){
        this.view = view;
        tree = new FamilyList<Person>();
    }
    public void addhuman(Person human){
        tree.add(human);
    }
    public FamilyList<Person> getTree(){
        return tree;
    }
    public void getListInfo(){
        tree.print();
        view.printAnswer("Tree was printed");
    }
    public void sort_name(){
        tree.sort_name();
        view.printAnswer("List is sorted now");
    }
    public void sort_age(){
        tree.sort_age();
        view.printAnswer("List is sorted now");
    }
}
