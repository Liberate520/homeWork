package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class It {
    private String dateOfDeath;
    private String dateOfBorn;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String placeOfBirth;
    private String gender;
    private List<It> children;

    private int id;


    public boolean isAlive() {
        return dateOfDeath.isEmpty();
    }

    public int getAge() {
        Dates dates = new Dates();
        HashMap<String, Integer> firstDate = dates.parseDate(dateOfBorn);
        HashMap<String, Integer> secondDate;
        if (isAlive()) {
            secondDate = dates.parseDate(dates.getTodayDate());
        } else {
            secondDate = dates.parseDate(dateOfDeath);
        }
        if (secondDate.get("month") - firstDate.get("month") < 0) {
            return secondDate.get("year") - firstDate.get("year") - 1;
        } else {
            return secondDate.get("year") - firstDate.get("year");
        }
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getDateOfBorn() {
        return dateOfBorn;
    }
    public List<It> getChildren() {
        return children;
    }
    public String getGender() {
        return gender;
    }
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }
    public int getId() { return id; }
    public void createUnit(){}


}
