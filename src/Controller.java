
import java.util.List;

public class Controller {
    private SearchRelative searchRelative;

    public Controller() {
        this.searchRelative = new SearchRelative();
    }

    public List<String> searchRecitation(Human member, List<Relative> relatives) {
        return searchRelative.searchRelatives(member, relatives);
    }

    public Human searchMemberByRecitation(Human member, Recitation relative, List<Relative> relatives) {
        return searchRelative.searchMemberByRecitation(member, relative, relatives);
    }
}