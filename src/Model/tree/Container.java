package Model.tree;

import java.util.ArrayList;
import java.util.List;
public class Container<T extends Containerable> {
    List<Containerable> container;

    public Container() {
        this.container = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder elementsForPrint = new StringBuilder();
        for (Containerable element : container) {
            elementsForPrint.append(element.getVisibleName())
                    .append(" - ").append(element.getVisibleType()).append("\n");
        }

        return String.valueOf(elementsForPrint);
    }

    public List<Containerable> getContainer() {
        return container;
    }

    public Containerable choose(int command){
        return this.getContainer().get(command);
    }
}
