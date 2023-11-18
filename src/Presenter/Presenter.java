package Presenter;

import Model.home_work_class.Human.Gender;
import Model.Model;
import view.View;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view){
        this.view = view;
        this.model = new Model();
    }

    public void addHuman(String name, Gender gender, LocalDate bornDate, LocalDate diedDate){
        this.model.addHuman(name, gender, bornDate, diedDate);
        getHumansListInfo();
        view.printAnswer("Человек добавлен\n");
    }

    public void getHumansListInfo() {
        String info = model.getHumansListInfo();
        view.printAnswer(info);
    }

    public void fileWriter(){
        boolean res = this.model.fileWriter();
        if (res){
        this.view.printAnswer("Семейное дерево записано\n");}
        else {this.view.printAnswer("Семейное дерево не записано\n");}
    }

    public void fileReader(){
        boolean res = this.model.fileReader();
        if (res){
            getHumansListInfo();
            this.view.printAnswer("Семейное древо прочитано\n");
        }
        else {this.view.printAnswer("Семейное древо не прочитано\n");}
    }

    public void SortByName() {
        this.model.sortByName();
        getHumansListInfo();
        view.printAnswer("Дерево отсортировано по имени\n");
    }

    public void SortByAge() {
        this.model.sortByAge();
        getHumansListInfo();
        view.printAnswer("Дерево отсортировано по возрасту\n");
    }

    public void SortById() {
        this.model.sortById();
        getHumansListInfo();
        view.printAnswer("Дерево отсортировано по id\n");
    }
}
