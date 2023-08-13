package com.javacourse.Family_tree;

import java.io.IOException;

public class Service {
    private FamilyList<Person> tree;
    public Service(){
        this.tree = new FamilyList<>();
    }
    public void file_read() throws IOException{
        my_File myfile = new myFile();
        myfile.file();
        Boolean file = true;
        while (file){
            String[] params;
            params = myfile.read();
            if (params == null) break;
            System.out.println(params[3]);
            this.addhuman(params[0], Integer.valueOf(params[1]), params[2], params[3]);
        }
    }
    public void addhuman(String name, Integer age, String mom_name, String dad_name){
        Person human = new Person();
        human.buildperson(name, age);
        tree.add(human);
        if (tree.keySet().contains(mom_name)){
            human.setMom(tree.get(mom_name));
            tree.get(mom_name).children.add(human);
        }
        else if (mom_name != null){
            Person mom = new Person();
            mom.buildperson(mom_name, null);
            mom.children.add(human);
            tree.add(mom);
            human.setMom(mom);
        }
        if (tree.keySet().contains(dad_name)){
            human.setDad(tree.get(dad_name));
            tree.get(dad_name).children.add(human);
        }
        else if (dad_name != null){
            Person dad = new Person();
            dad.buildperson(dad_name, null);
            dad.children.add(human);
            tree.add(dad);
            human.setDad(dad);
        }
    }
    public void getListInfo(){
        tree.print();
    }
    public void sort_name(){
        tree.sort_name();
    }
    public void sort_age(){
        tree.sort_age();
    }
}
