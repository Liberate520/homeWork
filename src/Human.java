import java.time.LocalDate;

public class Human {
    private static int human_id;
    private int id;
    private String name;
    private String date;


    public Human(String name, String date) {
        this.name = name;
        this.date = date;
        id = human_id++;
    }


//    public Human() {
//        this("default", LocalDate.parse("00.00.0000"));
//    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    protected void displayFamilyTree() {
    }
}

