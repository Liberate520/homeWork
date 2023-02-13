public abstract class Person {
    private int id;
    private String name;
    private String thirdname;
    private String surname;
    private String sex;

    public Person(int id, String name, String thirdname, String surname, String sex) {
        this.id = id;
        this.name = name;
        this.thirdname = thirdname;
        this.surname = surname;
        this.sex = sex;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurName() {
        return surname;
    }
    public String getSex() {
        return sex;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + thirdname + " " + surname + "," + sex ;
    }
}