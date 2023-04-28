package FamilyTree.model.nodes;
//базовый класс для элементов, добавляемых в дерево, это могут быть люди и например, кошки или собаки (у породистых прослеживают родословную)

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
// import java.lang.StringBuilder;

public abstract class Node implements Serializable{
    static final long SerialVersionUID = 2023;
    private String name;
    private Gender gender;
    private int yearOfBirth;
    private int yearOfDeath;
    private Node father;
    private Node mother;
    private List <Node> children; 
 

    public Node (String name, Gender gender,int yearOfBirth,int yearOfDeath, Node father, Node mother) {
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();   
    }
    public Node (String name, Gender gender,int yearOfBirth, int yearOfDeath) {
        this(name, gender, yearOfBirth, yearOfDeath, null, null);
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }
   
    public Node getFather() {
    return father;
    } 

    public Node getMother(){
    return mother;
    }
    
    public List<Node> getChildren(){//получение списка детей
        return children;
    }
    
    public void addChild(Node child){//добавление ребенка в список детей
        children.add(child);
    }

    public void setYearOfDeath(int yod){
        this.yearOfDeath = yod;
    }

    public String getShortInfo(){
        String result = ""; 
        return result;
    }

    public String getFullInfo(){
        String result = ""; 
        return result;
    }
       
    public abstract boolean search (String text);//поиск по текстовым полям узла

    public void showChildren() { //вывод списка детей   
        if (children.size()>0){//если дети есть
            for(int i = 0; i < children.size(); i++){
                System.out.printf("%d ", i+1);
                System.out.println(children.get(i));
            }
        }
        
    }

    
}
