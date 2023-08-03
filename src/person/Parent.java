import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Parent implements Serializable, Marriage, Comparable<Parent>{
    private String name;
    private Gender gender;
    private int age;
    private String dateBorn;
    private String dateDeath;
    private List<List<Parent>> pairs;
    
    public Parent(String name, Gender gender, int age, String dateBorn) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dateBorn = dateBorn;
        this.pairs = new ArrayList<>();
    }
    
    public Parent(String name, Gender gender, int age, String dateBorn, String dateDeath) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dateBorn = dateBorn;
        this.dateDeath = dateDeath;
        this.pairs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public int getAge() {
        return age;
    }

    public List<List<Parent>> getPairs() {
        return pairs;
    }
    @Override
    public int compareTo(Parent o) {
        return name.compareTo(o.name);
    }
    // Метод "Женим людей"
    @Override
    public void marry(Parent person1, Parent person2) {
        List<Parent> pair = new ArrayList<>();
        pair.add(person1);
        pair.add(person2);

        if (pairs.contains(pair)) {
            System.out.println("Пара [" + person1.getName() + ", " + person2.getName() + "] уже содержится в списке.");
        } else {
            System.out.println("Пара [" + person1.getName() + ", " + person2.getName() + "] поженилась.");
            pairs.add(pair);
        }
    }

    @Override
    public String toString() {
        if (dateDeath == null){
        return name + ", пол " + gender + ", возраст " + age + ", " + "Дата рождения: " + dateBorn;
        } else 
        return name + ", пол " + gender + ", возраст" + age + ", " + "Дата рождения: " + dateBorn + ", " + "Дата смерти: " + dateDeath;
    }
}
