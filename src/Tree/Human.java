package Tree;

public class Human extends Communications {
  
    private static final Human people2 = null;
    private static final Human people1 = null;
    private static final Relations relationType = null;
    private final String name;
    private final int age;

    public Human(String name, int age) {
        super(people1, people2, relationType);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return ("ФИО: "+getName()+"; возраст:"+getAge());
    }
}
