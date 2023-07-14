package homeWork.FamalyTree.model.Service.SaveLoad;

import java.io.File;

import homeWork.FamalyTree.model.FamalysTree.FamalyTree;
import homeWork.FamalyTree.model.FamalysTree.ItemTree;

public interface SaveLoad<E extends ItemTree<E>> {
    void Save(FamalyTree<E> list, File file);
    FamalyTree<E> LoadDate(FamalyTree<E> list, File file);
}

