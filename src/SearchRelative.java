
import java.util.ArrayList;
import java.util.List;

public class SearchRelative {

    public SearchRelative() {

    }

    public List<String> searchRelatives(Human member, List<Relative> relatives) {
        List<String> ties = new ArrayList<>();
        for (Relative w1 : relatives) {
            if (member.equals(w1.getMember1())) {
                ties.add(w1.getMember2().getName() + " " + w1.getMember2().getSurname() + " -" +
                        w1.getStringRecitation(w1.getRelative()));
            }

        }
        return ties;
    }

    public Human searchMemberByRecitation(Human member, Recitation relative, List<Relative> relatives) {
        Human search = new Human();
        for (Relative w2 : relatives) {
            if (member.equals(w2.getMember2()) && relative.equals(w2.getRelative())) {
                search = w2.getMember1();
            }

        }
        return search;
    }

}