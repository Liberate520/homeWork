package data;

import data.field.Text;

public class SimpleNote extends Note {

    public SimpleNote(String description) {
        super(description);
        super.addField(new Text("Простой текст"));
    }

}
