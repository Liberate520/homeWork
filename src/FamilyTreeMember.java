import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FamilyTreeMember{
    private final Human human;
    private Set<FamilyTree> familyTrees = new HashSet<>();
    private Map<FamilyConnection, Set<FamilyTreeMember>> connections = new HashMap<>();

    public FamilyTreeMember(Human human, FamilyTree familyTree) {
        this.human = human;
        familyTrees.add(familyTree);
    }

    /**
     * Add member link to FamilyTree
     */
    public void addToFamilyTree(FamilyTree tree) {
        familyTrees.add(tree);
    }

    /**
     * Connect members with 'connection'
     * @param member Second member
     * @param connection Connection type
     */
    public void connectMember(FamilyTreeMember member, FamilyConnection connection) {
        if (!connections.containsKey(connection)) {
            connections.put(connection, new HashSet<>());
        }
        connections.get(connection).add(member);
    }

    public Set<FamilyTreeMember> getRelatedMembers(FamilyConnection connection) {
        return connections.get(connection);
    }

    public Set<FamilyTree> getFamilyTrees() {
        return familyTrees;
    }

    @Override
    public String toString() {
        String humanStr = (human==null)?"Нет данных" : human.toString();
        return "FamilyTreeMember{" + humanStr + '}';
    }
}
