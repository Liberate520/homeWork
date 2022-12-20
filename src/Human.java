
public class Human {

    private String name, surname, gender, age;

    public Human(String name, String surname, String age, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void surname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[имя - " + name + ", " + "фамилия - " + surname + ", " + "пол - " + gender + ", " + "возраст - " + age
                + "]";
    }
}