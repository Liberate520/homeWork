package gb.task_4;

import java.io.Serializable;
import java.util.List;

public abstract class LiveBeing<T> implements Serializable, Comparable<T> {

    public abstract String getName();

    public abstract int getDate();

    public abstract void setName(String name);

    public abstract List<T> getChildren();

    protected abstract int generateNowDate();

    protected abstract String getRandomSex();

    public abstract void setFather(T father);

    public abstract void setMother(T mother);
}
