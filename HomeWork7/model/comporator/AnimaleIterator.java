package HomeWork7.model.comporator;

import java.util.Iterator;
import java.util.List;

import HomeWork7.model.Animale;

public class AnimaleIterator<T extends Animale> implements Iterator<T>
{
    private int index;
    private List<T> humans;

    public AnimaleIterator(List<T> humans)
    {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() // есть ли следующий элемент
    {
        return humans.size() > index;
    }

    @Override
    public T next() // выдает элемент
    {
        return humans.get(index++);
    }
    
}
