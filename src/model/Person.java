package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Itemable {

    private int id;
    private String surname;
    private String name;
    private int age;


    private List<Relation> relations;

    public Person(List<Itemable> list,String surname, String name, int age) {
        this.id = setId(list);
        this.surname = surname;
        this.name = name;
        this.age = age;

    }
//    public Person(String name, String surname, int age){
//        this.name = name;
//        this.age = age;
//        this.surname = surname;
//    }

    public Person() {
    }

    @Override
    public int getId() {
        return id;
    }

    private int setId(List<Itemable> list) {
        int upperRange = 1000;
        Random random = new Random();
        int tempId = random.nextInt(upperRange);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == tempId){
                tempId++;
                i = 0;
            }
        }
        return this.id = tempId;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }
    
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public List<Relation> getRelations() {
        return relations;
    }
    
    @Override
    public void setRelationship(Relation relationship) {
        
        if (this.relations == null){
            ArrayList<Relation> temp = new ArrayList<>();
            temp.add(relationship);
            this.relations = temp;
        }
        else{
            this.relations.add(relationship);
        }
    }
    
    @Override
    public String itemToString(){
        StringBuilder res;
        res = new StringBuilder("id: " + this.id + "\n" + "Фамилия: " + this.surname + "\n" + "Имя: " + this.name + "\n" +
                  "Возраст: " + this.age + "\n" + "Связи: " + "\n");
        if (this.relations != null){
            for (Relation r : this.relations){
                    res.append("с человеком ").append(r.getRelationToHumanId()).append(" существует связь - ")
                            .append(r.getRelation()).append("\n");
                }
        }            
        return res.toString();
    }
    
    @Override
    public String childrensToString(){
        StringBuilder res = new StringBuilder();
        if (this.relations != null){
            for (Relation r : this.relations){
                if (r.getRelationId() == 2){ //2 - 'это связь дети в Relationships'
                    res.append("Id ребенка ").append(r.getRelationToHumanId());
                }    
            }
        }
        return res.toString();
    }
}

