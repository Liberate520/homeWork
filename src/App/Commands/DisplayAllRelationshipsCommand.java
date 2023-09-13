package App.Commands;

import App.Command;
import Model.GenealogyPresenterInterface;
import Model.FamilyMember;
import Model.Relationship;
import Model.Tree.FamilyTree;

import java.util.List;

public class DisplayAllRelationshipsCommand implements Command {
    private final GenealogyPresenterInterface presenter;

    public DisplayAllRelationshipsCommand(GenealogyPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        FamilyTree<FamilyMember> familyTree = presenter.getFamilyTree();
        List<Relationship> allRelationships = familyTree.getAllRelationships();

        System.out.println("All Relationships:");
        for (Relationship relationship : allRelationships) {
            System.out.println(formatRelationship(relationship));
        }
    }

    @Override
    public String getDescription() {
        return "Display All Relationships";
    }

    private String formatRelationship(Relationship relationship) {
        return String.format("%s - %s - %s",
                relationship.getPerson1().getFullName(),
                relationship.getType(),
                relationship.getPerson2().getFullName());
    }


    // Остальные методы formatRelationship и другие вспомогательные методы можно перенести сюда, если необходимо
}
