public class Human extends Essence {
    private String lastName;
    private Gender gender;
    private String age;
    public Human(String name, String lastName, Gender gender, String age) {
        super(name);
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

}
