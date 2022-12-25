
public class Cats extends Human {
    private String name;
    private String gender;
    private Integer age;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Cats(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;

    }

    @Override
    public String toString() {
        return
                "Имя= " + name +
                        ", Пол = " + gender +
                        " Возраст = " + age;
    }


}

