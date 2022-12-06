package model;

import java.util.ArrayList;
import java.util.List;

public class Human extends TreePerson {
    // человеку нужно имя
//    private String fullName;
    // гендер 0=Ж 1=М
//    private int gender;
    // у человека будут связи
    private List<Link> links;

    public Human(String name, int gender) {
        super(name, gender);

//        this.fullName = fullName; // имя есть всегда и изначально
//        this.gender = gender;
        links = new ArrayList<>();
//        this.addHumanList(this);
    }


    // прикрепляем человека к дереву


    //добавляем связь через имя связи
    @Override
    public void addLink(Link link) {
        this.links.add(link);
    }

    //добавляем связь через конструктор связей
//    public void addLink(Human second, int tipeLink) {
//        new Link(this, second, tipeLink);
//    }

    public List<Link> getLink() {
        return links;
    }
    public Link getLink(int i) {
        return links.get(i);
    }

//    public int getGender() {
//        return gender;
//    }


}
