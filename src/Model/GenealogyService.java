package Model;

import Model.Tree.FamilyTree;
public class GenealogyService {
    private final FamilyTree<FamilyMember> model;
    public GenealogyService(FamilyTree<FamilyMember> model) {
        this.model = model;
    }
}