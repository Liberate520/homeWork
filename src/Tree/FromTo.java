package Tree;

import Elements.TreeElement;

public interface FromTo {
   <E extends TreeElement> void saveTo(GenealogicalTree<E> family);
   GenealogicalTree readFrom(String fileName);
}
