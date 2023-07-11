package familyTree;

 import java.io.Serializable;
 import java.util.ArrayList;
 import java.util.Arrays;

 public class Human implements Serializable {
     private boolean alive;
     private String name;
     private String sex;
     private int age;
     private ArrayList<Human> children = new ArrayList<>();
     private Human[] parents = new Human[2];
     private static final long serialVersionUID = 1L;

     public Human() {
         this.alive = true;
         this.name = "Очередняра";
         this.sex = "муж";
         this.age = 18;
     }

     public Human(boolean alive, String name, String sex, int age) {
         this.alive = alive;
         this.name = name;
         this.sex = sex;
         this.age = age;
     }

     // Геттеры
     public boolean isAlive() {
         return alive;
     }

     public String getName() {
         return name;
     }

     public String getSex() {
         return sex;
     }

     public int getAge() {
         return age;
     }

     // public void - реализовать логику getChildren при отсутствии детей

     public ArrayList<Human> getChildren() {
         return children;
     }

     public Human[] getParents() {
         return parents;
     }

     // Сеттеры
     public void setAlive(boolean alive) {
         this.alive = alive;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setSex(String sex) {
         this.sex = sex;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public void setChildren(ArrayList<Human> children) {
         this.children = children;
     }

     public void setParents(Human[] parents) {
         this.parents = parents;
     }

     @Override
     public String toString() {
         if (alive) {
             return "Человек жив" + ", зовут " + name + ", пол " + sex + ", возраст " + age + " лет, дети=" + children
                     + ", родители=" + Arrays.toString(parents);
         } else {
             return "Человек умер" + ", звали " + name + ", пол " + sex + ", в возрасте " + age + " лет, дети=" + children
             + ", родители=" + Arrays.toString(parents);
         }
     }

 }