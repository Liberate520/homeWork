package data.field;

public abstract class Field {
    String description;
    String value;

    public Field(String description) {
        this.description = description;
    }

    protected void setValue(String value) {
        this.value = value;
    }
}
