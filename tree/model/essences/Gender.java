package model.essences;

public enum Gender {
    Male("1"),
    Female("2");

    public String name;

    private Gender(String stringVal) {
        name = stringVal;
    }

    public String toString() {
        return name;
    }

}
