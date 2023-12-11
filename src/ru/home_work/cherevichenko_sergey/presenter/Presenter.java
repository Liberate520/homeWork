package ru.home_work.cherevichenko_sergey.presenter;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.service_tree.ServiceTree;
import ru.home_work.cherevichenko_sergey.view.View;

import java.time.LocalDate;

public class Presenter {
    View view;
    ServiceTree service;

    public Presenter(View view) {
        this.view = view;
        service = new ServiceTree();
    }
    public void addHuman(String name, String lastName, Gender gender,
                         LocalDate birthDay, LocalDate dateDeath){
        service.addHuman( name, lastName,  gender, birthDay, dateDeath);
    }
    public void getHumanInfo(){
        String answer = service.getHumanInfo();
        view.printAnswer(answer);
    }
    public void addChildForFamily(String motherName, String motherLastName, String fatherName,
                                  String fatherLastName, String nameChild, String lastNameChild){
        String answer = service.addChildForFamily( motherName,motherLastName,fatherName,
                 fatherLastName,nameChild,lastNameChild);
        view.printAnswer(answer);

    }
    public  void  removeHuman(String name,String lastName){
        String answer = service.removeHuman(name,lastName);
        view.printAnswer(answer);

    }
    public void findChildren(String name,String lastName){
        String answer = service.findChildren(name,lastName);
        view.printAnswer(answer);

    }
    public void sortByName(){
        service.sortTreeByName();
       String answer = service.getHumanInfo();
       view.printAnswer(answer);
    }
    public void sortByAge(){
        service.sortTreeByAge();
        String answer = service.getHumanInfo();
        view.printAnswer(answer);
    }
    public void sortByLastName(){
        service.sortTreeByLastName();
        String answer = service.getHumanInfo();
        view.printAnswer(answer);
    }
    public void sortByCountChildren(){
        service.sortTreeByCountChildren();
        String answer = service.getHumanInfo();
        view.printAnswer(answer);
    }
    public void save() throws Exception{
        service.save();

    }
    public void read() throws Exception{
        service.read();
    }

}
