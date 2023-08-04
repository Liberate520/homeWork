import java.util.*;
public class Person{
    private String lfm;
    private Person mom;
    private Person dad;
    private Integer age;
    public ArrayList<String> children;

    public void buildPerson(String lfm, Person mom, Person dad, Integer age, ArrayList<String> children){
        this.lfm = lfm;
        this.mom = mom;
        this.dad = dad;
        this.age = age;
        this.children = children;
        this.reset();
    }
    public String getName(){
        return this.lfm;
    }
    public Person getDad(){
        return this.dad;
    }
    public Person getMom(){
        return this.mom;
    }
    public Integer getAge(){
        return this.age;
    }
    public ArrayList<String> getChildren(){
        return this.children;
    }
    private void reset(){
        if (this.dad == null) {
            this.dad = new Person();
            this.dad.lfm = null;
        }
        if (this.mom == null) {
            this.mom = new Person();
            this.mom.lfm = null;
        }
    }

}