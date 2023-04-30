package Presenter;

import Services.Service;

import ui.ConsoleUi;
import ui.View;

import java.io.IOException;


public class Presenter {
    private View view;
    public Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public Presenter(Service service) {
        this.service = service;
        view.setPresenter(this);
    }

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void setView(View view) {
        this.view = view;
//        view.setPresenter(this);
    }

    public void setService(Service service) {
        this.service = service;
//        view.setPresenter(this);
    }

    public void PrintTree() {
        view.print(service.printTree().toString());
    }
    public void SortBySecondName(){
        view.print(service.sortBySecondName().toString());}
    public void LoadTree() throws IOException, ClassNotFoundException {
        service.loadTree();
    }

    public void SaveTree() throws IOException {
        service.saveTree();
    }

    public void SortBySex(){
        view.print(service.sortBySex().toString());}
    public void sortByBirthYear(){
        view.print(service.sortByYear().toString());
        }
    }

