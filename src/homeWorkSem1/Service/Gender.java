package homeWorkSem1.Service;

public enum Gender {

    Male("Male"), Female("Female");

    private String string;
    Gender gend;

    private Gender(String string) {
        this.string = string;
    }

    public String getGender1() {
        return string;
    }

    public Gender setGender(String g) {
        for (Gender gender : Gender.values()) {
            if (gender.getGender1() == g) {
                gend = Gender.Female;
            }
            else gend = Gender.Male;
        }
        return gend;   
    }
}
