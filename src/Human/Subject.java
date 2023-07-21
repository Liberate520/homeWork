package Human;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Subject<E>{
    public HashSet<E> children = new HashSet<>();

    public abstract E getMother();
    public abstract E getFather();
    public abstract String getSurname();
    public abstract String getStatus();
    public abstract LocalDate getBirthDate();
    public abstract String getName();
    public abstract HashSet<E> getChildren();



    public abstract void setStatus(String newStatus);

    public abstract void setName(String newName);

    public abstract void setSurname(String newSurname);

    public abstract void setBirthDate(LocalDate of);
    public abstract void setMother(E human);

    public void setFather(E human) {
    }

}
