package homeWork.familytree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyMember {
    private String name;
    private LocalDate dateOfBirth;
    private List<FamilyMember> children;

    public FamilyMember(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    public void addChild(FamilyMember child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name;
    }
}
