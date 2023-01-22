package Model.tree;

import java.util.ArrayList;
import java.util.List;
public class Container<T extends Containerable> {
    List<Containerable> container;

    public Container() {
        this.container = new ArrayList<Containerable>();
    }

    @Override
    public String toString() {
        StringBuilder elementsForPrint = new StringBuilder();
        for (Containerable element : container) {
            elementsForPrint.append("\n").append(element.getVisibleName()).append(" - ").append(element.getVisibleType());
        }

        return "В контейнере сейчас следующие элементы:\n" + elementsForPrint;
    }

    public List<Containerable> getContainer() {
        return container;
    }

    public void setContainer(List<Containerable> container) {
        this.container = container;
    }
}
