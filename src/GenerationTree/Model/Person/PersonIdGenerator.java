package GenerationTree.Model.Person;

import java.io.Serializable;

public class PersonIdGenerator implements Serializable {
    private int id;

    private static PersonIdGenerator idGenerator;

    private PersonIdGenerator() {
    }

    public int GetNewId() {
        return id++;
    }

    public static PersonIdGenerator getIdGenerator() {
        if (idGenerator == null)
            idGenerator = new PersonIdGenerator();
        return idGenerator;
    }
}
