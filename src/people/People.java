package people;

public class People {
        private String name;
        int age;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Имя: " + name + " Возраст: " + age;
    }
}
