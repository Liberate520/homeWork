package model.member;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String name;
    Gender(String name) {this.name = name;}

    @Override
    public String toString() {
        return name;
    }
    public static Gender fromString(String name) {
        for (Gender gender:Gender.values()) {
            if (name.equals(gender.name)) return gender;
        }
        return null;
    }
}
