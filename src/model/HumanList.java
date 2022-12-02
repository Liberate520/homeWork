package model;

import java.util.ArrayList;
import java.util.List;
import view.Menu;

public class HumanList {
    List<Human> list;

    public HumanList(){
        this.list = new ArrayList<Human>();

        // тестовые ребята
        // Вася
        Human vasya = new Human();
        vasya.setId(11); 
        vasya.setName("Василий");
        vasya.setAge(40);
        list.add(vasya);
        System.out.println(vasya.getRelationships());

        // Марина
        Human marina = new Human();
        marina.setId(22); 
        marina.setName("Марина");
        marina.setAge(50);
        list.add(marina);

        // Петя
        Human petya = new Human();
        petya.setId(33); 
        petya.setName("Петр");
        petya.setAge(10);
        list.add(petya);

        // Петя сын Васи
        Relationship vasyapetya = new Relationship(2,33);
        vasya.setRelationship(vasya,vasyapetya);

    }

    public List<Human> getHumanList() {
        return this.list;
    }

    public Human get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    public void addHuman(){
        Human humanToAdd = new Human(list, Menu.getName(), Integer.parseInt(Menu.getAge()));
        this.list.add(humanToAdd);
    }

    public void removeHuman(){
        int idForMenu = Integer.parseInt(Menu.getId());
            int tempId = 0;
            int count = 0;
            for (Human human : list){
                if (human.getId() == idForMenu){
                    tempId = count;
                }
                count++;
            }
            list.remove(tempId);
    }

    public void printChildrens(){
        int idForMenu = Integer.parseInt(Menu.getId());
            for (Human human : list){
                if (human.getId() == idForMenu){
                    human.printChildrens(human);
                }
            }
    }

    public void addReletionToHuman(){
        int idForMenu = Integer.parseInt(Menu.getId());
            for (Human human : list){
                if (human.getId() == idForMenu){
                    Relationship relationship = new Relationship(Integer.parseInt(Menu.getIdRelation()),
                                                        Integer.parseInt(Menu.getIdTo()));
                    human.setRelationship(human,relationship);
                }
            }
    }

    public void addToTxt(){
        int idForMenu = Integer.parseInt(Menu.getId());
            for (Human human : list){
                if (human.getId() == idForMenu){
                    SaveToTxt txt = new SaveToTxt();
                    txt.saveAs(human.getHuman(human));
                }
            }
    }

    public void addToDoc(){
        int idForMenu = Integer.parseInt(Menu.getId());
            for (Human human : list){
                if (human.getId() == idForMenu){
                    SaveToDoc doc = new SaveToDoc();
                    doc.saveAs(human.getHuman(human));
                }
            }
    }
}
