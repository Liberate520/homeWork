package Model.tree;

public interface Containerable {

    default void addToContainer(Container container){
        container.container.add(this);
    }

    String getVisibleName();
    String getVisibleType();
}
