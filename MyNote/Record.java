package MyNote;

public class Record {
    private String text;

    public Record(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
      
        return text;
    }
}