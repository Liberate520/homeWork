package model;

import java.util.ArrayList;
import java.util.List;

public class HumanList {
    private int lastId;
    private final List<Human> list;
    public HumanList(){
        lastId = 3;
        this.list = new ArrayList<>();
        Human vladimir = new Human();
        vladimir.setId(1);
        vladimir.setName("Vladimir");
        vladimir.setAge(30);
        list.add(vladimir);
        System.out.println(vladimir.getRelation());

        Human viktoriia = new Human();
        viktoriia.setId(2);
        viktoriia.setName("Viktoriia");
        viktoriia.setAge(29);
        list.add(viktoriia);

        Human lev = new Human();
        lev.setId(3);
        lev.setName("Lev");
        lev.setAge(5);
        list.add(lev);

        Relation relation1 = new Relation(1, 2);
        vladimir.setRelation(relation1);
        Relation relation2 = new Relation(2, 3);
        viktoriia.setRelation(relation2);
    }

    public Human get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    public String printHumanList(){
        StringBuilder result = new StringBuilder();
        for (Human h : this.list){
            result.append(h.printHuman(h)).append("\n");
        }
        return result.toString();
    }

    public String addHuman(String name, int age){
        Human humanAdd = new Human(list, name, age);
        humanAdd.setId(lastId++);
        this.list.add(humanAdd);
        return "Add human:\n" + humanAdd.printHuman(humanAdd);
    }

    public String removeHuman(int idMenu){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == idMenu){
                Human removeHuman = list.get(i);
                list.remove(i);
                return "Remove:\n" + removeHuman.printHuman(removeHuman);
            }
        }
        return "Human is not found";
    }

    public String printChildren(int idMenu){
        for (Human h: list){
            if(h.getId() == idMenu){
                return "Child:\n" + h.printChildren(h);
            }
        }
        return "Children is not found";
    }

    public String addRelationHuman(int idMenu, int relationId, int relationHumanId){
        for (Human h: list) {
            if (h.getId() == idMenu){
                Relation relation = new Relation(relationId, relationHumanId);
                h.setRelation(relation);
                return "Relation add";
            }
        }
        return "Relation is not found";
    }
}
