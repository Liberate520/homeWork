public class Passanger {

    private int id;
    private String name;
    private String lastName;
    private int numberPassport;
    public Passanger(int id, String name, String lastName, int numberPassport) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.numberPassport = numberPassport;
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
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getNumberPassport() {
        return numberPassport;
    }
    public void setNumberPassport(int numberPassport) {
        this.numberPassport = numberPassport;
    }

    @Override
    public String toString() {
        return String.format("name: %s, lastname: %s, passport: %d", name, lastName, numberPassport);
    }
}