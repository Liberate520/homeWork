package Models.Relation;

import java.io.Serializable;
import java.util.Objects;

public class Relation<E> implements Serializable {
    private final E object;
    private final RelationType objectType;


    public Relation(E object, RelationType objectType) {
        this.object = object;
        this.objectType = objectType;
    }


    //region Getters

    public E getObject() {
        return object;
    }

    public RelationType getObjectType() {
        return objectType;
    }

    //endregion

    //region DefaultOverride

    @Override
    public int hashCode() {
        return Objects.hash(object, objectType);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Relation && this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s as %s", object, objectType);
    }

    //endregion
}
