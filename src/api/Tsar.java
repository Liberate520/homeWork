package api;

public class Tsar extends Person
{
    private Integer yearOfReignStart;
    private Integer yearOfReignStop;

    private Integer leaderNumber;

    public Tsar(String name,
                String middleName,
                String surname,
                Gender gender,
                Integer yearOfBirth,
                Integer yearOfDeath,
                Integer leaderNumber,
                Integer yearOfReignStart,
                Integer yearOfReignStop
                )
    {
        super(name,middleName,surname,gender,yearOfBirth,yearOfDeath);
        this.leaderNumber = leaderNumber;
        this.yearOfReignStart = yearOfReignStart;
        this.yearOfReignStop = yearOfReignStop;
    }

    public void setYearOfReignStart(Integer yearOfReignStart) {
        this.yearOfReignStart = yearOfReignStart;
    }

    public void setYearOfReignStop(Integer yearOfReignStop) {
        this.yearOfReignStop = yearOfReignStop;
    }

    public Integer getYearOfReignStart() {
        return yearOfReignStart;
    }

    public Integer getYearOfReignStop() {
        return yearOfReignStop;
    }

    public String printAll()
    {
        String result = "";
        result += "Правящий монарх:\n";
        result += super.printInfo();
        result += "\t" + "Годы правления\t\t" + yearOfReignStart + " - " + yearOfReignStop + "\n";
        result += "\t" + "Порядок правления\t" + leaderNumber + "\n";
        result += "\n";
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "api.Tsar{" +
                "yearOfReignStart=" + yearOfReignStart +
                ", yearOfReignStop=" + yearOfReignStop +
                ", leaderNumber=" + leaderNumber +
                '}';
    }
}
