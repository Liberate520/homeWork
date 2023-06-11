package model.members;

public enum Gender {
    MAN("Man"),
    WOMAN("Woman"),
    ;

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public static Gender fromStringValue(String value) {
        for (Gender enumValue : Gender.values()) {
            if (enumValue.getGender().equalsIgnoreCase(value)) {
                return enumValue;
            }
        }
        return null;
    }
}
