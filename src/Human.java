public class Human {
    private String firstName, lastName, sex;
    private int day, month, year;

    Human(String firstName, String secondName, int day, int month, int year, String sex) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return (this.firstName + " " + this.lastName);
    }

    @Override
    public int hashCode() {
        int result = (firstName != null ? firstName.hashCode() : 0) * (lastName != null ? lastName.hashCode() : 0) *
                    (day) * (month) * (year) * (sex != null ? sex.hashCode() : 0);

        return result + 99999999;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        Human that = (Human) obj;
        if (firstName != that.firstName ||
            lastName != that.lastName ||
            day != that.day ||
            month != that.month ||
            year != that.year ||
            sex != that.sex) return false;

        return true;
    }

}
