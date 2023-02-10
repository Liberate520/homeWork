import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Human {
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    private String gender;
    private String dateOfBorn;

    private String dateOfDeath;
    private String placeOfBirth;
    private String firstName;
    private String patronymic;
    private String lastName;

    //На потом
//    private final int id;
//
//    static class Stat {
//        public static int counter = 0;
//        public static int id = 0;
//    }
//    {
//        Stat.counter++;
//        id = ++Stat.id;
//    }
//    public int getId() {
//        return id;

    @Override
    public String toString() {
        return "Human{" +
                ", gender='" + gender + '\'' +
                ", dateOfBorn='" + dateOfBorn + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
//    }


    public Human(Human father, Human mother, List<Human> children, String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        if (isValidGender(gender)) {
            this.gender = gender;
        }
        if (isDateValid(dateOfBorn, false)) {
            this.dateOfBorn = dateOfBorn;
        }
        if (isDateValid(dateOfDeath, true)) {
            this.dateOfDeath = dateOfDeath;
        }
        this.placeOfBirth = placeOfBirth;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public Human() {
    }

    public Human(Human father, Human mother, String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        this.father = father;
        this.mother = mother;
        this.gender = gender;
        this.dateOfBorn = dateOfBorn;
        this.dateOfDeath = dateOfDeath;
        this.placeOfBirth = placeOfBirth;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public Human(String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        this.gender = gender;
        this.dateOfBorn = dateOfBorn;
        this.dateOfDeath = dateOfDeath;
        this.placeOfBirth = placeOfBirth;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    //переписать не будет пустого!
    public boolean isAlive() {
        return dateOfDeath.isEmpty();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(String dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void addChild(Human human) {
        this.children.add(human);
    }

    private String getTodayDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    public int getAge() {
        HashMap<String, Integer> firstDate = parseDate(dateOfBorn);
        HashMap<String, Integer> secondDate;
        if (isAlive()) {
            secondDate = parseDate(getTodayDate());
        } else {
            secondDate = parseDate(dateOfDeath);
        }
        if (secondDate.get("month") - firstDate.get("month") < 0) {
            return secondDate.get("year") - firstDate.get("year") - 1;
        } else {
            return secondDate.get("year") - firstDate.get("year");
        }
    }


    //парсим дату
    private HashMap<String, Integer> parseDate(String date) {
        HashMap<String, Integer> result = new HashMap<>();
        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        if (date.isEmpty()) {
            return result;
        }
        try {
            Date parDate = sd.parse(date);
            calendar.setTime(parDate);
            int day = calendar.get(Calendar.DATE);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            result.put("year", year);
            result.put("month", month);
            result.put("day", day);
            return result;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return result;
        }
    }


    //isValid
    private boolean isValidGender(String gender) {
        return (Objects.equals(gender, "Female") || Objects.equals(gender, "Male") || Objects.equals(gender, "None"));
    }

    public boolean isDateValid(String date, boolean ifEmpty) {
        if (ifEmpty) {
            if (date.isEmpty()) {
                return true;
            }
        }
        boolean isTrueDate = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate dDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException ex) {
            isTrueDate = false;
//            ex.printStackTrace();
        }
        return isTrueDate;
    }
}

