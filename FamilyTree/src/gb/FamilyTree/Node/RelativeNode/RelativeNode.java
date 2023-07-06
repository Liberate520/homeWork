package gb.FamilyTree.Node.RelativeNode;

import java.time.LocalDate;

import gb.FamilyTree.Node.Node;

public class RelativeNode extends Node {
    private String firstName;
    private String lastName;
    private String middleName;

    private LocalDate birthDate;
    private LocalDate deathDate;

    public RelativeNode(int id, String lastName, String firstName, String middleName, String birthDate,
            String deathDate) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;

        this.birthDate = LocalDate.parse(birthDate);
        this.deathDate = LocalDate.parse(deathDate);
    }

    public RelativeNode(int id, String lastname, String firstName, String middleName) {
        this(id, lastname, firstName, middleName, LocalDate.MIN.toString(), LocalDate.MAX.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(String.format("%s %s %s. ", this.lastName, this.firstName, this.middleName));

        return builder.toString();
    }
}
