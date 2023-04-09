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




}
