package App.Commands;

import App.Command;
import Model.GenealogyPresenterInterface;
import Model.FamilyMember;
import Model.Relationship;
import Model.Tree.FamilyTree;

public class DisplayFamilyTreeCommand implements Command {
    private final GenealogyPresenterInterface presenter;

    public DisplayFamilyTreeCommand(GenealogyPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        FamilyTree<FamilyMember> familyTree = presenter.getFamilyTree();

        System.out.println("All People:");
        for (FamilyMember familyMember : familyTree) {
            System.out.println(formatFamilyMember(familyMember));
        }
    }

    @Override
    public String getDescription() {
        return "Display Family Tree";
    }

    private String formatFamilyMember(FamilyMember familyMember) {
        String deathInfo = familyMember.isAlive() ?
                familyMember.getAge() + " years (Alive)" :
                familyMember.getAge() + " years (Died " + familyMember.getYearsSinceDeath() + " years ago)";

        return String.format("Name: %s%nGender: %s%nBirth Date: %s%nDeath Date: %s%n%s%nRelationships:%n%s%n",
                familyMember.getFullName(),
                familyMember.getGender(),
                familyMember.getBirthDate(),
                familyMember.getDeathYear(),
                deathInfo,
                formatRelationships(familyMember));
    }

    private String formatRelationships(FamilyMember familyMember) {
        StringBuilder relationships = new StringBuilder();
        for (Relationship relationship : presenter.getFamilyTree().getRelationships(familyMember)) {
            relationships.append("  ")
                    .append(formatRelationship(relationship))
                    .append("\n");
        }
        return relationships.toString();
    }

    private String formatRelationship(Relationship relationship) {
        return String.format("%s - %s - %s",
                relationship.getPerson1().getFullName(),
                relationship.getType(),
                relationship.getPerson2().getFullName());
    }
    // Остальные методы formatFamilyMember и другие вспомогательные методы можно перенести сюда, если необходимо
}
