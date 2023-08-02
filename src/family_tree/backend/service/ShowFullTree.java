package family_tree.backend.service;

import family_tree.backend.Engine;
import family_tree.backend.ftree.FamilyTree;
import family_tree.backend.ftree.Relatives;
import family_tree.backend.person.Person;

public class ShowFullTree<P extends Relatives<P>> implements PrintTree{
    private Engine engine;
    private FamilyTree<P> relations;
    public ShowFullTree(){
        this.relations = new FamilyTree<>();
    }

    public String getFullRelativesInfo(){
        StringBuilder sB = new StringBuilder();
        sB.append("\n");
        sB.append("===================\n");
        sB.append("Full Family tree:\n");
        sB.append("----===========----\n");
        for (P person: relations){
            sB.append(person.getID());
            sB.append(". ");
            sB.append(person.getPerson());
            if (person.getMother() != null || person.getFather() != null){
                sB.append("\n :: Parents: ");
                if (person.getMother().getPerson() != null){
                    sB.append(person.getMother().getPerson());
                }
                if (person.getMother() != null && person.getFather() != null) {
                    sB.append(" & ");
                }
                if (person.getFather().getPerson() != null) {
                    sB.append(person.getFather().getPerson());
                }
            }
            sB.append(person.getPersonChildrens());
            sB.append(person.getPersonSiblings());
            sB.append("\n");
            sB.append("----===========----\n");
        }

        return sB.toString();
    }

}
