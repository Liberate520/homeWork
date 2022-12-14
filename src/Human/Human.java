package Human;

import java.util.ArrayList;
//поиск и отображение детей
public class Human {
    private String name;
    private int age;
    private Human parent1;
    private Human parent2;
    private ArrayList<Human> children = new ArrayList();
    public void setParent1(Human parent1) {
        this.parent1 = parent1;
    }
    public void setParent2(Human parent2) {
        this.parent2 = parent2;
    }
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
    public Human getParent1() {
        return parent1;
    }
    public Human getParent2() {
        return parent2;
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
    public void setAge(int age) {
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
        if (parent1 != null){
            result += "\n" + "  Родитель 1: " + parent1.name;
        }
        if (parent2 != null){
            result += "\n" +"  Родитель 2: " + parent2.name;
        }
        if (getChildren().size()>0){
            for (int i = 0; i < getChildren().size(); i++) {
                result += "\n" + "  Ребенок " + (i+1) +": " + getChildren().get(i).name;
            }
        }
        return result;
    }
}
