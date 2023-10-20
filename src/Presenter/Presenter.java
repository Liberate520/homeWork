package Presenter;

import Model.FamTreeModel.Human.Gender;
import Model.FamTreeModel.Human.Human;
import Model.FamTreeModel.Service;
import view.View;

public class Presenter {
    private View view;
    public Service servise;

    public Presenter(View view){
        this.view = view;
        servise = new Service();
    }
    public void addHuman(String fname, String lname, Gender sex, int age){
        servise.addHuman(fname,lname,sex,age);
        System.out.println("Человек добавлен в дерево!");
//        servise.getHumanListInfo();
    }
    public void addHumanChildrenById(long id, String fname, String lname, Gender sex, int age){
        servise.addHumanChildren(id, fname, lname,sex, age);
    }
    public void loadTree(String path){
        servise.loadTree(path);
    }
    public void saveTree(String path){
        servise.saveTree(path);
    }
    public void getHumanListInfo() {
        view.getAnsw(servise.getHumanListInfo());
    }

    public void sortByName(){
        servise.sortName();
        getHumanListInfo();
    }
    public void sortByAge(){

        servise.sortAge();
        getHumanListInfo();
    }
}
