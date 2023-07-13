package homeWork.FamalyTree.SaveLoad;

import java.io.File;

import homeWork.FamalyTree.FamalysTree.FamalyTree;

public interface SaveLoad {
    void Save(FamalyTree list, File file);
    FamalyTree LoadDate(FamalyTree list, File file);
}

