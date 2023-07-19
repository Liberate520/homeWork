package family_tree.model;

import family_tree.model.tree.Treeable;

interface Creater<E> {
    public E createNewItem();
}
