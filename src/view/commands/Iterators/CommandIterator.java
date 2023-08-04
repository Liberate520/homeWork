package view.commands.Iterators;

import view.commands.Command;

import java.util.Iterator;
import java.util.List;

public class CommandIterator implements Iterator {
    private int index;
    public List<Command> commandList;
    public CommandIterator(List<Command> commandList){
        this.commandList = commandList;
    }
    @Override
    public boolean hasNext() {
        return index < commandList.size();
    }

    @Override
    public Object next() {
        return commandList.get(index++);
    }
}
