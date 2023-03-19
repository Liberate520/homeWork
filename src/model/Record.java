package model;

public abstract class Record {
    protected String text;

    public Record(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("Запись: %s \t", text);
    }
}
