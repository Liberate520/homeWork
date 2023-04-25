package tree.human;

import java.util.ArrayList;
import java.util.List;

public class Cat implements FamilyTreeItem {
    private Gender gender;
    private String breed;
    private String name;
    private Integer age;
    private Cat husband;
    private Cat mother;
    private Cat father;
    private List<Cat> children;

    public Cat(Gender gender, String name, Integer age, Cat mother, Cat father, Cat husband, String breed) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.mother = mother;
        this.father = father;
        this.husband = husband;
        this.breed = breed;
        this.children = new ArrayList<>();
    }

    public Cat(Gender gender, String name, Integer age, Cat mother, Cat father, Cat husband) {
        this(gender, name, age, mother, father, husband, null);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public Gender getGender() {
        return Gender.Male;
    }

    public String getBreed() {
        return breed;
    }

    public Cat getMother() {
        return mother;
    }

    public Cat getFather() {
        return father;
    }

    public Cat getHusband() {
        return husband;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather(Cat father) {
        this.father = father;
        // if (!father.getChildren().contains(this.getName())) father.addChild(this);
    }

    public void setMother(Cat mother) {
        this.mother = mother;
        // if (!mother.getChildren().contains(this.getName())) mother.addChild(this);
    }

    public void addHusband(Cat husband){
        this.husband = husband;
        if (husband.getHusband() == null) husband.addHusband(this);
    }

    public void addChild(Cat child) {
        if(!children.contains(child)){
            children.add(child);
            if (this.getGender() == Gender.Male) {
                if (child.getFather() != this) child.setFather(this);
            }
            else{
                if(child.getMother() == null) child.setMother(this);
            }
        }
    }

    public List<String> getChildrenNames() {
        List<String> res = new ArrayList<>();
        for (Cat human : children) {
            res.add(human.getName());
        }
        return res;
    }

    @Override
    public String toString() {
        String m = "";
        String f = "";
        String h = "";
        List<String> c = new ArrayList<>();
        if (mother != null) m = mother.getName();
        if (father != null) f = father.getName();
        if (husband != null) h = husband.getName();
        if (children != null) c = this.getChildrenNames();
        return "Имя: " + name + " Возраст: " + age + " пол: " + gender + " Мать: " + m + " Отец: " + f + " Супруг/супруга: " + h +" Дети: " + c;
    }
}
