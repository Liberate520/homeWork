package Model.units;

public class Human extends Unit {

    private String secondName;


    public Human(String firstName, String secondName, Human mother,
                 Human father, Gender gender, int birthday, int birthmonth,
                 int birthyear) {
        super(firstName, mother, father, gender, birthday, birthmonth,
              birthyear);
        this.secondName = secondName;
    }

    public Human(String firstName, String secondName, Gender gender,
                 int birthday, int birthmonth, int birthyear) {
        this(firstName, secondName, null, null, gender, birthday, birthmonth,
             birthyear);
    }

    @Override
    public String getName() {
        return super.getName() + " " + secondName;
    }
}
