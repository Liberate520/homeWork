package view.commands;

import view.commands.Iterators.CommandIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandList extends ArrayList<Command> implements Iterable<Command>{
    public ArrayList<Command> commandList;
    PersonAdder personAdder = new PersonAdder();
    ReaderFromFile readerFromFile =  new ReaderFromFile();
    SorterByAge sorterByAge = new SorterByAge();
    SorterByName sorterByName = new SorterByName();
    TreePrinter treePrinter = new TreePrinter();
    WriterToFile writerToFile = new WriterToFile();
    Exit exit = new Exit();
    SetSpouse setSpouse = new SetSpouse();
    SetChild setChild = new SetChild();
    public CommandList (){
        commandList = new ArrayList<>();
        commandList.add(personAdder);
        commandList.add(treePrinter);
        commandList.add(sorterByAge);
        commandList.add(sorterByName);
        commandList.add(writerToFile);
        commandList.add(readerFromFile);
        commandList.add(setSpouse);
        commandList.add(setChild);
        commandList.add(exit);

    }

    @Override
    public Iterator iterator() {
        return new CommandIterator(this.commandList);
    }


}
