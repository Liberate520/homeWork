package ru.gb.presenter;

import ru.gb.model.human.Human;
import ru.gb.model.service.Service;
import ru.gb.view.View;

import java.io.IOException;
import java.util.Scanner;


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
    public void sortByName(){
        service.sortByName();
        getInfo();
    }
    public void sortByAge(){
        service.sortByAge();
        getInfo();
    }
    public void getInfo(){
        String answer = service.getInfo();
        view.printAnswer(answer);
    }
    public void setConnection(Scanner scanner) {
        service.setConnection(scanner);
        getInfo();
    }
    public void save() throws IOException {
        service.save();
        System.out.println("Данные сохранены в файл");
    }
    public void load() throws IOException, ClassNotFoundException {
        service.load();
        System.out.println("Данные загружены из файла");
    }
    public Human createHuman(Scanner scanner){
        return service.createHuman(scanner);
    }
}
