package gb.FamilyTree.Node.RelativeNode;

import java.time.LocalDate;

import gb.FamilyTree.Node.Node;

public class RelativeNode extends Node {
    private String firstName;
    private String lastName;
    private String middleName;

    private LocalDate birthDate;
    private LocalDate deathDate;

    public RelativeNode(String lastName, String firstName, String middleName, String birthDate, String deathDate) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;

        this.birthDate = LocalDate.parse(birthDate, null);
        this.deathDate = LocalDate.parse(deathDate, null);
    }

    public RelativeNode(String lastname, String firstName, String middleName) {
        this(lastname, firstName, middleName, LocalDate.MIN.toString(), LocalDate.MAX.toString());
    }
}
