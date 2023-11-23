package presenter;

import model.human.Human;
import model.human.gender.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }
//По сути, переписываю с сервиса, но методы - ссылочные
    //TODO ОБЯЗАТЕЛЬНО ДОПИЛИТЬ-ТАКИ БИЛДЕР! Чтобы можно было переопределять!
    public void addObject(String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father){
        service.addObject(name, gender, birthDay, deathDay, mother, father);
    }

    public void getHumanInfo(){
        //здесь понятно - вызываем метод из сервиса,
        String info = service.getHumanInfo();
        //видимо, во вьюшке лежит метод печати всех методов? Пока не смотрю
        view.printAnswer(info);
    }
    public void sortByName(){
        service.sortByName();
        getHumanInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getHumanInfo();
    }
    //TODO rewrite method addMother into addChild
    public void addChild(Human parent, Human child){
        service.addChild(parent, child);
        getHumanInfo();
    }
//    public void getMarried(Human wife, Human husband){
//        service.getMarried(wife, husband);
//        getHumanInfo();
//    }
    //Now it's normal, later I'll add methods like deathDateMaker,
    // divorceMaker, maybe marriageCounter etc
}
