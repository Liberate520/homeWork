import java.time.LocalDate;
import java.util.List;

public class Person {
    private String Surname;
    private String FirstName;
    private String MiddleName;
    private String Sex;
    private int DayOfBirth;
    private int MonthOfBirth;
    private int YearOfBirth;
    public boolean Alive;

    Person Father;
    Person Mother;
    List<Person> children;

    public Person(String Surname, String FirstName, String MiddleName, String Sex){
        this.Surname = Surname;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.Sex = Sex;
    }

    public int getAge() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int year = date.getYear();
        int month = date.getMonthValue();
        int day= date.getDayOfMonth();
        int Age = year - this.YearOfBirth - 1;
        if (month > this.MonthOfBirth){
            Age = Age + 1;
        }
        if ((month == this.MonthOfBirth)){
            if (day >= this.DayOfBirth){
                Age = Age + 1;
            }
        }
        return Age;
    }

    public void setYearOfBirth(int yearOfBirth) {
        YearOfBirth = yearOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        MonthOfBirth = monthOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        DayOfBirth = dayOfBirth;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }
}
