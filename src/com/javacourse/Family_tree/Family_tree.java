package com.javacourse.Family_tree;
import java.io.IOException;
import java.util.Map;

import com.javacourse.view.ConsoleUI;


public class Family_tree {
    public static void main(String[] args) throws IOException{
        /*Person me = new Person();
        Person myDad = new Person();
        Person myMom = new Person();
        FamilyList<Person> mytree = new FamilyList<Person>();
    
        my_File myfile = new myFile(new File("FamilyList.txt"));
        myfile.file();
        String[] params;
        params = myfile.read();
        me.buildperson(params[0], Integer.valueOf(params[1]));
        params = myfile.read();
        myDad.buildperson(params[0], Integer.valueOf(params[1]));
        params = myfile.read();
        myMom.buildperson(params[0], Integer.valueOf(params[1]));
        me.setDad(myDad);
        me.setMom(myMom);
            
        mytree.add(myDad);
        mytree.add(myMom);
        mytree.add(me);
        mytree.sort_age();

        mytree.print();*/

        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}

