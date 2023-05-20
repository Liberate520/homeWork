package model.Tree;

import model.Elements.TreeElement;

public interface FromTo {
   <E extends TreeElement> void saveTo(GenealogicalTree<E> family);
   GenealogicalTree readFrom(String fileName);
}
