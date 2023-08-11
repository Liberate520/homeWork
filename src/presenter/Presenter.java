package presenter;

import jdk.jfr.Percentage;
import model.Gender;
import model.Person;
import model.Service;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPerson(String firstName, String lastName, String surName,
                           LocalDate dateOfBirth, Gender gender){
        if (service.addPerson(firstName, lastName, surName, dateOfBirth, gender)){
            view.printAnswer("Человек успешно добавлен в древо!");
            view.printAnswer(service.getHumanListInfo());
        }else {
            view.printAnswer("Человек не добавлен! Что то пошло не так...");
        }
    }
    public void getHumanListInfo(){
        String info = service.getHumanListInfo();
        view.printAnswer(info);
    }

    public void sortByName(){
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getHumanListInfo();
    }

    public void findPerson(String name){
        view.printAnswer("Список всех людей с именем " + name + ": ");
        view.printAnswer(service.findPerson(name));
    }

    public int getHumanListSize(){
        return service.getHumanListSize();
    }

    public void setMather (int idChild, int idMather){
        service.setMather(idChild, idMather);
        view.printAnswer("Информация обновлена!");
        view.printPerson(service.getPersonById(idChild));
    }

    public void setFather (int idChild, int idFather){
        service.setFather(idChild, idFather);
        view.printAnswer("Информация обновлена!");
        view.printPerson(service.getPersonById(idChild));
    }

    public void saveTree () {
        try {
            service.saveTree();
            view.printAnswer("Древо сохранено!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadTree() {
        try {
            service.loadTree();
            view.printAnswer("Дерево загружено!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getChildren(int id){
        String children;
        children = service.getChildren(id);
        view.printAnswer(children);
    }


}
