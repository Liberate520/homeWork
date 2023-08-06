package familyTree;

public class Human {
    private int id;
    private String name;
    private String lastname;
    private String birthdate;

    public Human(String name, String lastname, String birthdate) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public String getBirtchdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", lastname: " + lastname + ", birhtdate: " + birthdate + " г.р.";
    }
}