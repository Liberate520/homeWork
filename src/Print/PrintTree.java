package Print;

import Homework_6.Designer_Human;
import Homework_6.Femily_Tree;
import Iterator.StaddyIterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class PrintTree implements InterfacePrint,Iterable<Designer_Human>{
    Femily_Tree femily_tree;

    @Override
    public void printTree() {
        forEach(Designer_Human -> System.out.println());
        forEach(System.out::println);
    }

    @Override
    public Iterator<Designer_Human> iterator() {
        return new StaddyIterator(femily_tree.humans);
    }

    @Override
    public  void forEach(Consumer<? super Designer_Human> action) {
        Iterable.super.forEach(action);
    }
}
