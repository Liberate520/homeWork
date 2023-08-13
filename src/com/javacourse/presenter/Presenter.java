package com.javacourse.presenter;
import com.javacourse.view.View;

import java.io.IOException;

import com.javacourse.Family_tree.*;

public class Presenter {
    private View view;
    private Service service = new Service();

    public Presenter(View view) throws IOException{
        this.view = view;
        service.file_read();
    }
    public void addhuman(String name, Integer age, String mom_name, String dad_name){
        service.addhuman(name, age, mom_name, dad_name);
    }
    public void getListInfo(){
        service.getListInfo();
        view.printAnswer("Tree was printed");
    }
    public void sort_name(){
        service.sort_name();
        view.printAnswer("List is sorted by name now");
    }
    public void sort_age(){
        service.sort_age();
        view.printAnswer("List is sorted by name now");
    }
}
