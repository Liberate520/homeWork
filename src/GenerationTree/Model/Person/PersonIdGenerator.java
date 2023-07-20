package GenerationTree.Model.Person;

public class PersonIdGenerator {
    private int id;

    public int GetNewId() {
        return id++;
    }
}
