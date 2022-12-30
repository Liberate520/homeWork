package homeWorkSem1;

import java.util.ArrayList;
import java.util.List;


public class Human {
    
    private String name;
    private int age;
    private boolean gender;
    public Human father;
    private Human mother;
    public List<Human> children = new ArrayList<>();

    enum Gender {
        Male, Female
    }
    
    /**Создание нового объекта */
    public Human(String name, int age, boolean gender, Human father, Human mother) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
          
    }

    /**Получение инф-ии о братьях/сестрах */
    public List<Human> getSisBro() {
        List<Human> sis = new ArrayList<>();
        try {
            for (var h : father.children) {
                if (name != h.name) {
                    sis.add(h); 
                }
            }
            if (sis.isEmpty()) {
                System.out.println("братьев/сестер нет");
            }
        }
        catch (Exception e) {
            System.out.println("братье/сестер нет");
        }
        return sis;   
    }

    /**Получение инф-ии о братьях/сестрах */
    public List<Human> getGrands() {
       List<Human> grands = new ArrayList<>();
       grands.add(father.father);
       grands.add(father.mother);
       grands.add(mother.mother);
       grands.add(mother.father);
       return grands;
    }

    
    /**Переопределение метода toString */
    @Override
    public String toString() {
        String temp = gender ? "male" : "female";
        return "Name: " + name + ", Age: " + age + ", Gender: " + temp + "\n";
    }

    /**Узнать имя */
    public String getName() {
        return name;
    }

    /**Узнать возраст */
    public int getAge() {
        return age;
    }

    /**Узнать пол */
    public boolean isGender() {
        return gender;
    }

    /**Получит  инф-ию об отце human */
    public Human getFather() {
        return father;
    }

    /**Получит  инф-ию о матери human */
    public Human getMother() {
        return mother;
    }

    /**Получить список детей для human */
    public List<Human> getChildren() {
        return children;
    }

    /**Задать имя */
    public void setName(String name) {
        this.name = name;
    }

    /**Задать возраст */
    public void setAge(int age) {
        this.age = age;
    }

    /**Задать пол */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**Задать отца для human */
    public void setFather(Human father) {
        this.father = father;
    }

    /**Задать мать для human */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**Задать список детей для human */
    public void setChildren(List<Human> children) {
        this.children = children;
    }
}
