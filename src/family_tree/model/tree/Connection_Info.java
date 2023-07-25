package family_tree.model.tree;

import family_tree.model.human.Gender;

import java.util.ArrayList;
import java.util.List;

public class Connection_Info<E extends SentientEntity<E>> {

    public String getSiblings(E child) {
        StringBuilder stringBuilder = new StringBuilder();
        List<E> siblings = new ArrayList<>();
        for (E parent : child.getParents().keySet()) {
            for (E sibling : parent.getChildren().keySet()) {
                if(!child.equals(sibling)
                        && !siblings.contains(sibling)) siblings.add(sibling);
            }
        }
        for (E sibling : siblings) {
            if(sibling.getGender().equals(Gender.female)){
                stringBuilder.append(sibling.getName());
                stringBuilder.append(" - ");
                stringBuilder.append("Сестра");
            }
            else if(sibling.getGender().equals(Gender.male)){
                stringBuilder.append(sibling.getName());
                stringBuilder.append(" - ");
                stringBuilder.append("Брат");
            }
        }
        return stringBuilder.toString();
    }
}
