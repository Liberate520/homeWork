package HW.model.human.enumerate;

public enum Sex {
    M("male"),
    F("female");
    private final String name;
    Sex(String name) {this.name = name;}

    @Override
    public String toString() {
        return name;
    }
    public static Sex fromString(String name) {
        for (Sex sex:Sex.values()) {
            if (name.equals(sex.name)) return sex;
        }
        return null;
    }
}
