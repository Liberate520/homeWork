package presenter;

import human.Human;
import service.Service;
import tree.FamilyTree;
import ui.Console;
import ui.View;
import ui.questions.Question;
import ui.questions.RepeatHuman;

import java.util.Date;
import java.util.Scanner;

public class Presenter {
    private Service service;
    private View view;
    public Presenter(Service service, View view) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void addHuman(String name, String surname, String bdate,String fatherName, String fatherSurname, String motherName, String motherSurname) {
        Human repeatHuman = service.getHumanByName(name,surname);
        if (repeatHuman!=null){
            Question question = new RepeatHuman((Console) view);
            if(question.answer().toLowerCase().equals("y")){
                service.deleteHuman(repeatHuman);
                view.print(service.addHuman(name,surname,bdate,fatherName,fatherSurname,motherName,motherSurname));
            }else{
                view.print("Отмена добавления");
            };
        }else{
            view.print(service.addHuman(name,surname,bdate,fatherName,fatherSurname,motherName,motherSurname));
        };
    }
    public void getFamilyTree(){
        view.print(service.getFamilyTree());
    }
    public void sortByName(){
        view.print(service.sortByName());
    }
    public void sortByBirthDay(){
        view.print(service.sortByBirthday());
    }
    public void getHuman(String name, String surname){
        view.print(service.getHuman(name, surname));
    }
    public void saveToFile() {
        if (service.saveToFile()) {
            view.print("Сохранение выполнено успешно");
        } else {
            view.print("Сохранение не выполнено");
        }
    }
    public void readToFile(){
            view.print(service.readToFile());
    }

}