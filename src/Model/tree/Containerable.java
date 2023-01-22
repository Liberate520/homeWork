package Model.tree;

public interface Containerable {

    public default void addToContainer(Container container){
        container.container.add(this);
    }

    public String getVisibleName();
    public String getVisibleType();
}
