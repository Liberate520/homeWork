package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class BasicEntity implements Serializable {
    private int id;
    private String name;
    private LocalDate dateOfBirth;

    // ==================================================================================
    // Constructors

    public BasicEntity(String firstName) {
        this(firstName, null);
    }

    public BasicEntity(String name, LocalDate dateOfBirth) {
        id = setId();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // ==================================================================================
    // Getters and Setters

    public int getId() {
        return id;
    }

    private int setId() {
        return Servis.assignID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // ==================================================================================

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(id + " ")
                .append(name + " ");
        if (dateOfBirth != null) {
            strb.append(dateOfBirth);
        }
        return strb.toString();
    }
}
