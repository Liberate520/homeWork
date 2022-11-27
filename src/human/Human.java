package human;

import java.util.ArrayList;
//поиск и отображение детей
public class Human {
    private String name;
    private int age;
    private Human perent1;
    private Human perent2;
    private ArrayList<Human> children = new ArrayList();
    public void setPerent1(Human perent1) {
        this.perent1 = perent1;
    }
    public void setPerent2(Human perent2) {
        this.perent2 = perent2;
    }
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
    public Human getPerent1() {
        return perent1;
    }
    public Human getPerent2() {
        return perent2;
    }
    public ArrayList<Human> getChildren() {
        return children;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getName() {

        return name;
    }
    public void setAge(String name) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public Human(String name, int age){
        this.name = name;
        this.age = age;
        children = new ArrayList<>();
    }
    public  void addChildren(Human human){
        if(!children.contains(human)){
            children.add(human);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human)obj;
        return human.name.equals(this.name);
    }

    @Override
    public String toString() {
        String result = "Имя: " + name + " Возраст: " + age ;
        if (perent1 != null){
            result += " Родитель 1: " + perent1.name;
        }
        if (perent2 != null){
            result += " Родитель 2: " + perent2.name;
        }
        if (getChildren().size()>0){
            for (int i = 0; i < getChildren().size(); i++) {
                result +=  " Ребенок " + (i+1) +": " + getChildren().get(i).name;
            }
        }
        return result;
    }
}
