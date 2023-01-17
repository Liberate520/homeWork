package Homework_004.controller;

import java.io.IOException;
import java.util.ArrayList;


import Homework_004.view.*;
import Homework_004.model.*;

public class Controller  {
    private View view;
    private FamilyTree familyTree;
    

    public Controller(View view) {
    this.view = view;
    view.setController(this);
    this.familyTree = new FamilyTree<>();
    }

    public void execCommand1() throws ClassNotFoundException, IOException{
        Writer writer = new Writer();
        this.familyTree= writer.read();
    }

    public void execCommand2(){
        this.familyTree.getAll();
        view.answer(this.familyTree);
    }

    public void execCommand3(){
        FamilyTreeService newFamilyTree = new FamilyTreeService(this.familyTree);
        newFamilyTree.sortById();
        view.answer(this.familyTree);
    }

    public void execCommand4(){
        FamilyTreeService newFamilyTree = new FamilyTreeService(this.familyTree);
        newFamilyTree.sortByDate();
        view.answer(this.familyTree);
    }

    public void execCommand5() throws ClassNotFoundException, IOException{
        Writer writer = new Writer();
        writer.save(this.familyTree);
    }

    public void execCommandExit(){
        return;
    }

    public void createNode(ArrayList<String> prop){
        Human node = new Human(prop.get(0), prop.get(1),prop.get(2));
        this.familyTree.add(node);
    }


}
