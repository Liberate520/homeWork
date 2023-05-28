import java.util.Calendar;

public class Human {
    private String fullName;
    private Gender gender;
    private final Calendar birthDate;
    private Calendar deathDate;

    public Human(String fullName, Gender gender, Calendar birthDate, Calendar deathDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Human(String fullName, Gender gender, Calendar birthDate) {
        this(fullName, gender, birthDate, null);
    }

    public Human(String fullName, Gender gender) {
        this(fullName, gender, null, null);
    }

    public String getName() {
        return fullName;
    }

    public void changeName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public Calendar getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Calendar deathDate) {
        this.deathDate = deathDate;
    }

    private String getFancyDate(Calendar calendar) {
        return String.format("%02d.%02d.%d",
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
    }

    @Override
    public String toString() {
        String datesString;
        if (birthDate == null) {
            datesString = "Неизвестно";
        } else {
            if (deathDate == null) {
                datesString = getFancyDate(birthDate);
            } else {
                datesString = String.format("%s - %s", getFancyDate(birthDate), getFancyDate(deathDate));
            }
        }
        return String.format("%s, %s", fullName, datesString);
    }
}
