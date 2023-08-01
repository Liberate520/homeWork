package ru.gb.presenter;

import ru.gb.model.human.Human;
import ru.gb.model.service.Service;
import ru.gb.view.View;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void addHuman(Human human) {
        service.addHuman(human);
    }
    public void SortByName(){
        service.SortByName();
        getInfo();
    }
    public void SortByAge(){
        service.SortByAge();
        getInfo();
    }
    public void getInfo(){
        String answer = service.getInfo();
        view.printAnswer(answer);
    }
    public void setConnection(Human child, Human parent) {
        service.setConnection(child, parent);
        getInfo();
    }
}
