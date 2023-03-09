package model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class BasicEntity implements Serializable {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<BasicEntity> children;
    private ArrayList<BasicEntity> parents;

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
        return EntityService.assignID();
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

    public ArrayList<BasicEntity> getChildren() {
        return children;
    }

    public ArrayList<BasicEntity> getParents() {
        return parents;
    }

    public ArrayList<BasicEntity> getSiblings() {
        ArrayList<BasicEntity> siblilings = new ArrayList<>();
        for (BasicEntity parent : parents) {
            for (BasicEntity child : parent.getChildren()) {
                if (getId() != child.getId() && !siblilings.contains(child))
                    siblilings.add(child);
            }
        }
        return siblilings;
    }

    // ==================================================================================

    private void addChild(BasicEntity person) {
        if (children == null)
            children = new ArrayList<>();
        if (!children.contains(person))
            children.add(person);
    }

    public void addParents(BasicEntity... entities) {
        if (parents == null)
            parents = new ArrayList<>();
        for (BasicEntity entity : entities) {
            if (!parents.contains(entity)) {
                parents.add(entity);
                entity.addChild(this);
            }
        }
    }

    public String fullInfo() {
        StringBuilder sb = new StringBuilder();
        ArrayList<BasicEntity> siblings = getSiblings();
        sb.append(this);
        sb.append(entityListToString(parents, "Parents"));
        sb.append(entityListToString(siblings, "Siblings"));
        sb.append(entityListToString(children, "Children"));
        return sb.toString();
    }

    private String entityListToString(ArrayList<BasicEntity> list, String header) {
        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) {
            sb.append("\n")
                    .append(header)
                    .append(":\n");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append("\n");
                }
            }            
        }
        return sb.toString();
    }

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
