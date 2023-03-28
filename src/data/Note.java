package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import data.field.Field;

public abstract class Note {
    private UUID id;
    private String description;
    private LocalDate creatingTime;
    private List<Field> fields;

    Note(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        fields = new ArrayList<>();
        creatingTime = LocalDate.now();
    }

    public void addField(Field field) {
        fields.add(field);
    }

}
