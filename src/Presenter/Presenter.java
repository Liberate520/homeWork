package Presenter;

import Model.FamTree.Human.Gender;
import view.View;

public class Presenter {
    private View view;
    private Service servise;

    public Presenter(View view){
        this.view = view;
        servise = new Service();
    }
    public void addHuman(String fname, String lname, Gender sex, int age){
        servise.addHuman(fname,lname,sex,age);
        System.out.println("Человек добавлен в дерево!");
//        servise.getHumanListInfo();
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
