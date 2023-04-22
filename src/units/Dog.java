package units;

public class Dog extends Unit {
    public Dog(String firstName, Dog mother, Dog father, Gender gender,
               int birthday, int birthmonth, int birthyear) {
        super(firstName, mother, father, gender, birthday, birthmonth,
              birthyear);
    }

    public Dog(String firstName, Gender gender, int birthday, int birthmonth,
               int birthyear) {
        this(firstName, null, null, gender, birthday, birthmonth, birthyear);
    }
}
