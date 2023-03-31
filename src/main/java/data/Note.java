package data;

public class Note {

    private String value;

    public Note(String description) {
        this.value = description;
    }
    public String getDescription(){
        return this.value;
    }

    @Override
    public String toString() {

        return this.value;
    }
}
