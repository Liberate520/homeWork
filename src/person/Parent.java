import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Parent extends Person implements Serializable, Marriage{
    private String dateBorn;
    private String dateDeath;
    private List<List<Person>> pairs;
    
    public Parent(String name, Gender gender, String age, String dateBorn) {
        super(name, gender, age);
        this.dateBorn = dateBorn;
        this.pairs = new ArrayList<>();
    }
    
    public Parent(String name, Gender gender, String age, String dateBorn, String dateDeath) {
        super(name, gender, age);
        this.dateBorn = dateBorn;
        this.dateDeath = dateDeath;
        this.pairs = new ArrayList<>();
    }

    public List<List<Person>> getPairs() {
        return pairs;
    }

    // Метод "Женим людей"
    @Override
    public void marry(Person person1, Person person2) {
        List<Person> pair = new ArrayList<>();
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
        return getName() + ", " + "Пол: " + getGender() + ", " + getAge() + ", " + "Дата рождения: " + dateBorn;
        } else 
        return getName() + ", " + "Пол: " + getGender() + ", " + getAge() + ", " + "Дата рождения: " + dateBorn + ", " + "Дата смерти: " + dateDeath;
    }
}
