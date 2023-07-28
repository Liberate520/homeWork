public class Human {
    private String name;
    private String last_name;
    private Gender gender;

    public Human(String name, String last_name, Gender gender) {
        this.name = name;
        this.last_name = last_name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Gender getGender() {
        return gender;
    }
}
